package ma.adria.bank.account.controller;

import ma.adria.bank.account.dto.DebitRequest;
import ma.adria.bank.account.entity.Account;
import ma.adria.bank.account.service.AccountService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.create(account);
    }

    @GetMapping
    public List<Account> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/{id}/debit")
    public Account debit(
            @PathVariable UUID id,
            @RequestBody DebitRequest request) {

        return service.debit(id, request.amount());
    }
}