package ma.adria.bank.transaction.repository;

import ma.adria.bank.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransactionRepository
        extends JpaRepository<Transaction, UUID> {
}