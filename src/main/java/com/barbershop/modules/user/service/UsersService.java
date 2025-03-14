package com.barbershop.modules.user.service;

import com.barbershop.common.exception.UserNotFoundException;
import com.barbershop.modules.user.model.Users;
import com.barbershop.modules.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<Users> listAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ese ID" + id));
    }

    @Override
    public Users saveUser(Users user) {

        return this.usersRepository.save(user);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteUser(Long id) {
        Users user = this.usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + id));

        user.setActive(false); // Cambia el estado en lugar de eliminarlo
        this.usersRepository.save(user);

        return ResponseEntity.ok("Usuario desactivado correctamente -> " + id);
    }


}
