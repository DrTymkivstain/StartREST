package com.example.startrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class MyController {
    @GetMapping(value = "/books/{id}")
    public @ResponseBody String getBookByID(Library library){
        return library.
                getBooks()
                .stream()
                .filter(book -> book.getId() == 1)
                .map(book -> book.getName())
                .findAny().orElse("no books find");
    }

    @PostMapping(value = "/books")
    public String createBook(){
        return "index.html";
    }

    @PutMapping(value = "/books/{id}")
    public String updateBook(){
        return "index.html";
    }

    @DeleteMapping(value = "/books/{id}")
    public String removeBook(){
        return "index.html";
    }

    @GetMapping(value = "/books/{id}")
    public String getMy2(){
        return "index.html";
    }
}
