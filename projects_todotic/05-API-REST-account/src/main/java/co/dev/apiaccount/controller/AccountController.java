package co.dev.apiaccount.controller;

import co.dev.apiaccount.documents.Account;
import co.dev.apiaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.rmi.server.LogStream.log;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    IAccountService iAccountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(iAccountService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {

        Account existAccount = iAccountService.findByPhoneNumber(account.getPhoneNumber());

        if (existAccount != null) {

            Account newAccount = iAccountService.create(account);

            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Account(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/accounts", params = "phoneNumber")
    public ResponseEntity<Account> findByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        Account findAccount = iAccountService.findByPhoneNumber(phoneNumber);

        if (findAccount != null) {
            return new ResponseEntity<>(findAccount, HttpStatus.OK);
        }

        return new ResponseEntity<>(new Account(), HttpStatus.NOT_FOUND);
    }
}
