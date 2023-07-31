package co.guipadev.contactos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "telefono")
public class Phone implements Serializable {

        /**
         * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
         */
        private static final long serialVersionUID = 1L;

        /**
         * Identificador de la tupla
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "tel_id", nullable = false)
        private Integer id;

        /**
         * Punto de enlace con la entidad Contacto (un contacto puede tener muchos número de teléfono)
         */
        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class, optional = false)
        @JoinColumn(name = "tel_contacto_id", nullable = false)
        @JsonBackReference
        private Contact contacto;

        /**
         * Número de teléfono
         */
        @Column(name = "tel_telefono", nullable = false, length = 30)
        private String telefono;

        /**
         * Fecha y hora en que la tupla ha sido creada
         */
        @Column(name = "tel_created_at", nullable = false, updatable = false)
        private Instant createdAt;

        /**
         * Fecha y hora en que la tupla ha sido actualizada por última vez
         */
        @Column(name = "tel_updated_at")
        private Instant updatedAt;

    }