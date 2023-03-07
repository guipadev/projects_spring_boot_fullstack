package xyz.yadev.persona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yadev.persona.model.Pais;
import xyz.yadev.persona.repository.IPaisRepository;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private IPaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

}
