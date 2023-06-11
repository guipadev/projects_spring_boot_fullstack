package yadev.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Estado;
import yadev.persona.repositorys.IEstadoRepository;

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
