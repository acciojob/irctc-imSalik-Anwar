package com.driver.controllers;

import com.driver.EntryDto.AuthorRequest;
import com.driver.model.Author;
import com.driver.services.Services;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mock")
public class Controller {

    final Services services;

    public Controller(Services services) {
        this.services = services;
    }

    // POST API Book name ,author name, no of pages
    @PostMapping("/add-book")
    public String addBook(@RequestParam("bookName") String bookName, @RequestParam("authorName") String authorName, @RequestParam("pages") int noOfPages){
        String response = services.addBook(bookName, authorName, noOfPages);
        return response;
    }
    // POST API - Add book author name , age ,gender,rating
    @PostMapping("add-author")
    public String addAuthor(@RequestBody AuthorRequest authorRequest){
        String response = services.addAuthor(authorRequest);
        return response;
    }

    // GET API - Find name of author and his/her age who have written maximum no. of pages during lifetime
    @GetMapping("/find-authors")
    public String findAuthors(){
        String response = services.findAuthors();
        return response;
    }

    // Find the total number of books published by author A in year Y.
    @GetMapping("/find-all-books/name/{name}/year/{year}")
    public Integer findAllBooks(@PathVariable("name") String name, @PathVariable("year") int year){
        int answer = services.findAllBooks(name, year);
        return answer;
    }
}
