package ma.adria.bank.transaction.producer;

import ma.adria.bank.transaction.event.TransactionCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionProducer {

    private static final String TOPIC = "bank.transactions.created";

    private final KafkaTemplate<String, TransactionCreatedEvent> kafkaTemplate;

    public TransactionProducer(
            KafkaTemplate<String, TransactionCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(TransactionCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event.accountId().toString(), event);
    }
}