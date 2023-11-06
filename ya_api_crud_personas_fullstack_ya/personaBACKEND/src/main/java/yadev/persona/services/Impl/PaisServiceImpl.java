package yadev.persona.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Pais;
import yadev.persona.repositorys.IPaisRepository;
import yadev.persona.services.IPaisService;

import java.util.List;

@Service
public class PaisServiceImpl implements IPaisService {

    private final IPaisRepository paisRepository;

    @Autowired
    public PaisServiceImpl(IPaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}