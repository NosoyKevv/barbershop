package com.barbershop.learnCriteria.repository;

import com.barbershop.learnCriteria.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findBookByAuthorNameAndTitle(String authorName, String title);
}
