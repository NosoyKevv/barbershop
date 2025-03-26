package com.barbershop.learnCriteria.repository;

import com.barbershop.learnCriteria.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

}
