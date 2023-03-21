package com.dev.open;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZooAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clase;
    private Integer edad;

    public ZooAnimal() {
    }

    public ZooAnimal(Long id, String nombre, String clase, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ZooAnimal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", edad=" + edad +
                '}' + "\n";
    }
}
