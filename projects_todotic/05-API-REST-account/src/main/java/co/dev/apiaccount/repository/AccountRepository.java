package co.dev.apiaccount.repository;

import co.dev.apiaccount.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    // Busqueda por número telefonico
    public Account findByPhoneNumber(String id);
}
