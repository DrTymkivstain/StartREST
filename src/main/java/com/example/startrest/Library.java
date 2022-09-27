package com.example.startrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
@Component
public class Library {
    private List<Book> books;

    public Library() {
       books = new ArrayList<>();
        System.out.println("suchesfull");
    }

    public List<Book> getBooks() {
        return books;
    }
}
