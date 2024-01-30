package com.carrefour.delivery.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderDTO {

    private Long id;

    @Size(max = 10)
    private String reference;

    @Size(max = 15)
    private String status;

    private Long iddelivery;

    private Long userid;

}
