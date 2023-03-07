package xyz.yadev.persona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.yadev.persona.model.Estado;
import xyz.yadev.persona.repository.IEstadoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private IEstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    // Metodo mostrar estados de acuerdo al pais selecionado
    public List<Estado> findAllByCountry (Long id) {
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estados = estadoRepository.findAll();
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).getPais().getId() == id) {
                estadosRespuesta.add(estados.get(i));
            }
        }
        return estadosRespuesta;
    }

    public List<Estado> findAll(Sort sort) {
        return estadoRepository.findAll(sort);
    }

}
