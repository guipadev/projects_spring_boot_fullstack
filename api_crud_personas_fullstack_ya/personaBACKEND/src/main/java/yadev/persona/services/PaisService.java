package yadev.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Pais;
import yadev.persona.repositorys.IPaisRepository;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private IPaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

}
