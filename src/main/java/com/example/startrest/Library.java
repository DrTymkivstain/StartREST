package com.example.startrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Library {
    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public Book getBookByID(Long id) {
        for(Book book : books) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        throw new NoSuchElementException("No book with this ID");
    }
    public void addBookByIndex(Book book, int index) {
        books.add(index,book);
    }

    public Library() {
       books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

}
