package co.dev.apiaccount.services;

import co.dev.apiaccount.documents.Account;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService extends ICRUDService<Account, String>{

    public Account findByPhoneNumber(String phoneNumber);
}
