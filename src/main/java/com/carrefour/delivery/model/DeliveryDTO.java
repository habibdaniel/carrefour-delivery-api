package com.carrefour.delivery.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private Long modeId;
    private LocalDateTime startSlotTime;
    private LocalDateTime endSlotTime;
    private LocalDate deliveryDay;

}
