package ma.adria.bank.transaction.service;

import ma.adria.bank.transaction.client.AccountClient;
import ma.adria.bank.transaction.entity.Transaction;
import ma.adria.bank.transaction.event.TransactionCreatedEvent;
import ma.adria.bank.transaction.producer.TransactionProducer;
import ma.adria.bank.transaction.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final AccountClient accountClient;
    private final TransactionProducer producer;

    @Value("${bank.transaction.max-amount:1000}")
    private BigDecimal maxAmount;

    public TransactionService(
            TransactionRepository repository,
            AccountClient accountClient,
            TransactionProducer producer) {

        this.repository = repository;
        this.accountClient = accountClient;
        this.producer = producer;
    }

    @Transactional
    public Transaction create(Transaction transaction) {

        // 1. Validate amount
        if (transaction.getAmount() == null ||
                transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        // 2. Check maximum amount
        if (transaction.getAmount().compareTo(maxAmount) > 0) {
            throw new IllegalArgumentException(
                    "Amount exceeds maximum limit: " + maxAmount);
        }

        // 3. Validate account ID
        if (transaction.getAccountId() == null) {
            throw new IllegalArgumentException("Account ID is required");
        }

        // 4. Validate currency
        if (transaction.getCurrency() == null ||
                transaction.getCurrency().isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }

        // 5. Get account from Account Service using Feign
        AccountClient.AccountResponse account =
                accountClient.getAccount(transaction.getAccountId());

        // 6. Check account status
        if (!"ACTIVE".equals(account.status())) {
            throw new IllegalArgumentException("Account is blocked");
        }

        // 7. Check currency
        if (!account.currency().equalsIgnoreCase(transaction.getCurrency())) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        // 8. Check balance
        if (account.balance().compareTo(transaction.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        // 9. Debit account
        accountClient.debit(
                transaction.getAccountId(),
                new AccountClient.DebitRequest(transaction.getAmount())
        );

        // 10. Save transaction
        Transaction saved = repository.save(transaction);

        // 11. Publish Kafka event
        TransactionCreatedEvent event = new TransactionCreatedEvent(
                saved.getId(),
                saved.getAccountId(),
                saved.getAmount(),
                saved.getCurrency()
        );

        producer.publish(event);

        return saved;
    }

    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Transaction findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Transaction not found: " + id));
    }
}