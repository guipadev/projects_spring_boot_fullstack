package co.guipadev.jaax.service;

import co.guipadev.jaax.entity.Local;
import co.guipadev.jaax.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;
    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localDb = localRepository.findById(id).get();

        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localDb.setCode(local.getCode());
        }

        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localDb.setFloor(local.getFloor());
        }

        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localDb.setName(local.getName());
        }

        return localRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {

    }
}
