package com.barbershop.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPasswordChange {
    private String userName;
    private String password;

}
