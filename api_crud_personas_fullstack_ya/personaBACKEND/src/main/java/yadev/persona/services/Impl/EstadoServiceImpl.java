package yadev.persona.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Estado;
import yadev.persona.repositorys.IEstadoRepository;
import yadev.persona.services.IEstadoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoServiceImpl implements IEstadoService {

    private final IEstadoRepository estadoRepository;

    @Autowired
    public EstadoServiceImpl(IEstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @Override
    public List<Estado> findAllByCountry(Long id) {
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estados = estadoRepository.findAll();
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).getPais().getId() == id) {
                estadosRespuesta.add(estados.get(i));
            }
        }
        return estadosRespuesta;
    }

    @Override
    public List<Estado> findAll(Sort sort) {
        return estadoRepository.findAll(sort);
    }

}
