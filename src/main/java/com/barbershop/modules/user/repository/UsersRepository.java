package com.barbershop.modules.user.repository;

import com.barbershop.modules.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
