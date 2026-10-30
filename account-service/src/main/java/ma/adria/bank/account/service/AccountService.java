package ma.adria.bank.account.service;

import ma.adria.bank.account.entity.Account;
import ma.adria.bank.account.entity.AccountStatus;
import ma.adria.bank.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(Account account) {

        if (account.getBalance() == null ||
                account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid balance");
        }

        if (account.getCurrency() == null ||
                account.getCurrency().isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }

        if (account.getCustomerReference() == null ||
                account.getCustomerReference().isBlank()) {
            throw new IllegalArgumentException("Customer reference is required");
        }

        account.setStatus(AccountStatus.ACTIVE);

        return repository.save(account);
    }

    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)

    public Account findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }
    public Account update(Account account) {
        return repository.save(account);
    }

    public Account debit(UUID id, BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Account account = findById(id);

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException("Account is blocked");
        }

        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        return repository.save(account);
    }
}