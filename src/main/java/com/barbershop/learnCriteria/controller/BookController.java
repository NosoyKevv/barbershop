package com.barbershop.learnCriteria.controller;

import com.barbershop.learnCriteria.entity.Book;
import com.barbershop.learnCriteria.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/search")
    @Operation(description = "List Books")
    public List<Book> searchBooks(@RequestParam String author, @RequestParam String title) {
        return bookRepository.findBookByAuthorNameAndTitle(author, title);
    }
}
