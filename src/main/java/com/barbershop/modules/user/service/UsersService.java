package com.barbershop.modules.user.service;


import com.barbershop.modules.user.dto.UserCreate;
import com.barbershop.modules.user.dto.UserPasswordChange;
import com.barbershop.modules.user.model.Users;

public interface UsersService {

    void create(UserCreate request);

    Users findById(Long id);

    String findUsernameById(Long id);

    void updatePass(Long id, UserPasswordChange request);

}
