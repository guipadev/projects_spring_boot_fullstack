package co.dev.apiaccount.services.Impl;

import co.dev.apiaccount.repository.AccountRepository;
import co.dev.apiaccount.documents.Account;
import co.dev.apiaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAccountServiceImpl implements IAccountService {

    // @Qualifier("accountRepository") // Diferenciar Beans
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findByPhoneNumber(String phoneNumber) {
        return accountRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account o) {
        return accountRepository.save(o);
    }
}
