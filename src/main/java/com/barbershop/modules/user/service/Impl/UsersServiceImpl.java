package com.barbershop.modules.user.service.Impl;

import com.barbershop.common.exception.ResourceConflictException;
import com.barbershop.common.exception.ResourceNotFoundException;
import com.barbershop.modules.person.service.PersonService;
import com.barbershop.modules.user.dto.UserCreate;
import com.barbershop.modules.user.dto.UserPasswordChange;
import com.barbershop.modules.user.model.Users;
import com.barbershop.modules.user.repository.UsersRepository;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements com.barbershop.modules.user.service.UsersService {

    private final UsersRepository usersRepository;
    private final PersonService personService;

    public UsersServiceImpl(UsersRepository usersRepository, PersonService personService) {
        this.usersRepository = usersRepository;
        this.personService = personService;
    }

    @Override
    public void create(UserCreate request) {
        if (usersRepository.existsByUsername(request.getUserName()) || usersRepository.existsByPersonId(request.getPersonId())) {
            throw new ResourceConflictException("Username already exists");
        }

        Users user = Users.createUser(
                request.getUserName(),
                request.getPassword(),
                personService.findById(request.getPersonId()));

        usersRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public String findUsernameById(Long id) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return users.getUsername();
    }

    @Override
    public void updatePass(Long id, UserPasswordChange request) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (user.getPassword().equals(request.getPassword())) {
            throw new ResourceConflictException("New password don't equal to old password");
        } else if (user.getUsername().equals(request.getUserName()) || usersRepository.existsByUsername(request.getUserName())) {
            throw new ResourceConflictException("New username don't equal to old username");
        }

        user.setUsername(request.getUserName());
        user.setPassword(request.getPassword());

        usersRepository.save(user);
    }
}
