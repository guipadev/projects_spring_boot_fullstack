package com.project.coches.persistance.entity;

import jakarta.persistence.Id;

public class CarPurchasePK {

    @Id
    private Integer purchaseNumberBill;

    @Id
    private Integer codeCar;

}
