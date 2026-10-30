package ma.adria.bank.account.dto;

import java.math.BigDecimal;

public record DebitRequest(BigDecimal amount) {
}