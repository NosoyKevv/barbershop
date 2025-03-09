package com.barbershop.modules.user.controller;

import com.barbershop.modules.user.dto.UsersDto;
import com.barbershop.modules.user.model.Users;
import com.barbershop.modules.user.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbershop/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDto>> listAllUsers() {
        List<Users> users = this.usersService.listAllUsers();
        List<UsersDto> usersDtos = users.stream()
                .map(user -> new UsersDto(user.getId(), user.getUsername(), user.getPassword()))
                .toList();
        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> findUserById(@PathVariable Long id) {
        Users user = this.usersService.findUserById(id);
        UsersDto usersDto = new UsersDto(user.getId(), user.getUsername(), user.getPassword());
        return ResponseEntity.ok(usersDto);
    }

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody Users users) {
        Users savedUser = this.usersService.saveUser(users);
        UsersDto responseDto = new UsersDto(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword());
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable Long id, @RequestBody UsersDto requestUserDto) {
        Users user = this.usersService.findUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setUsername(requestUserDto.getUserName());
        user.setPassword(requestUserDto.getPassword());

        this.usersService.saveUser(user);

        UsersDto responseDto = new UsersDto(user.getId(), user.getUsername(), user.getPassword());
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        this.usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
