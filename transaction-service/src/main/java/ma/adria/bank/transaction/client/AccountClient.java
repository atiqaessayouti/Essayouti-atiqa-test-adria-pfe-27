package ma.adria.bank.transaction.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.UUID;

@FeignClient(name = "account-service")
public interface AccountClient {

    @GetMapping("/api/accounts/{id}")
    AccountResponse getAccount(@PathVariable("id") UUID id);

    @PostMapping("/api/accounts/{id}/debit")
    AccountResponse debit(
            @PathVariable("id") UUID id,
            @RequestBody DebitRequest request
    );

    record AccountResponse(
            UUID id,
            String customerReference,
            String status,
            String currency,
            BigDecimal balance
    ) {}

    record DebitRequest(BigDecimal amount) {}
}