package ma.adria.bank.transaction.consumer;

import ma.adria.bank.transaction.event.TransactionCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @KafkaListener(
            topics = "bank.transactions.created",
            groupId = "bank-transaction-group"
    )
    public void consume(TransactionCreatedEvent event) {
        System.out.println("New transaction received: " + event);
    }
}