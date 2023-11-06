package com.gestion.productos.services;

import com.gestion.productos.model.Producto;
import com.gestion.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ProductoServices {

    @Autowired
    private ProductoRepository repositorio;

    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    public void guardarProducto(Producto producto) {
        repositorio.save(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return repositorio.findById(id).get();
    }

    public void eliminarProducto(Long id) {
        repositorio.deleteById(id);
    }
}
