package com.project.coches.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CarPurchaseRequestDto {

    private Integer numberBill;

    private String cardIdCustomer;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CarPurchaseRequestDto> x;
}
