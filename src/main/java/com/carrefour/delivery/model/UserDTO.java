package com.carrefour.delivery.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull
    @Size(max = 45)
    private String email;

    @NotNull
    @Size(max = 512)
    private String password;

    private LocalDateTime dateCreate;

    private LocalDateTime dateUpdate;

    private Long idrole;

}
