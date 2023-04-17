package com.yomdev.ecommerce.service.impl;

import com.yomdev.ecommerce.model.DetalleOrden;
import com.yomdev.ecommerce.repository.DetalleOrdenRepository;
import com.yomdev.ecommerce.service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

}