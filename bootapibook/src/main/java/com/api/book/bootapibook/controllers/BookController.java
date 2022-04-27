package com.api.book.bootapibook.controllers;

import java.util.List;

import com.api.book.bootapibook.entities.Book;
import com.api.book.bootapibook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks()
    {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id)
    {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        return this.bookService.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id)
    {
        this.bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable("id") int id)
    {
        this.bookService.updateBook(book,id);
        return book;
    }
}
 