package com.project.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity de compra
 *
 */
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @Id
    private Integer purchaseNumberBill;

    @Id
    private Integer codeCar;

    @Column(name = "cantidad")
    private Integer quantity;

    private Integer total;
}
