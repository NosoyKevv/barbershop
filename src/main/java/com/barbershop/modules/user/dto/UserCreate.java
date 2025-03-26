package com.barbershop.modules.user.dto;

import lombok.Getter;

@Getter
public class UserCreate {
    private String userName;

    private String password;

    private Long personId;
}
