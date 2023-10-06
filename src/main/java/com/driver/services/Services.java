package com.driver.services;

import com.driver.EntryDto.AuthorRequest;
import com.driver.model.Author;
import com.driver.model.Book;
import com.driver.repository.AuthorRepository;
import com.driver.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;

    public Services(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public String addBook(String bookName, String authorName, int noOfPages) {
        Book book = Book.builder()
                .name(bookName)
                .author_name(authorName)
                .pages(noOfPages)
                .build();

        bookRepository.save(book);
        return "Book has been added";
    }

    public String addAuthor(AuthorRequest authorRequest) {
        Author author = Author.builder()
                .name(authorRequest.getName())
                .age(authorRequest.getAge())
                .gender(authorRequest.getGender())
                .rating(authorRequest.getRating())
                .build();

        authorRepository.save(author);

        return "Author has been added";
    }

    public String findAuthors() {
        List<Book> list = bookRepository.findAll();
        int maxPages = Integer.MIN_VALUE;
        String author = "";

        for(Book book : list){
            if(book.getPages() > maxPages){
                maxPages = book.getPages();
                author = book.getAuthor_name();
            }
        }

        return author;
    }

    // Find the total number of books published by author A in year Y.
    public int findAllBooks(String name, int year) {
        // didn't code this API due to time. He just asked the approach.
        return 0;
    }
}
