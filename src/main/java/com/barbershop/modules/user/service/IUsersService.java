package com.barbershop.modules.user.service;

import com.barbershop.modules.user.model.Users;

import java.util.List;

public interface IUsersService {

     List<Users> listAllUsers();

     Users findUserById(Long id);

     Users saveUser(Users user);

     void deleteUser(Long id);

}
