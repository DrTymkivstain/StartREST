package com.example.startrest;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MyController {
    private final Library library;

    public MyController(Library library) {
        this.library = library;
    }

    @GetMapping(value = "books/{id}")
    public @ResponseBody String getBookByID(@PathVariable("id") Long id) {
        return library.
                getBooks()
                .stream()
                .filter(book -> book.getId().equals(id))
                .map(Book::getName)
                .findAny().orElse("no books find");
    }

    @PostMapping(value = "/books")
    public String createBook(@RequestBody Book book) {
        library.addBook(book);
        return "r";
    }

    @PutMapping(value = "/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        for (int i = 0; i < library.getBooks().size(); i++) {
            if (library.getBooks().get(i).getId().equals(id)) {
                library.addBookByIndex(book, i);
            }
        }
        return "put";
    }

    @DeleteMapping(value = "/{id}")
    public String removeBook(@PathVariable Long id) {
        List<Book> books = library.getBooks();
        books.removeIf(b -> b.getId().equals(id));
        library.setBooks(books);
        return "delete";
    }

    @GetMapping(value = "/books")
    public List<Book> getBookByParametrs(@RequestParam(required = false, value = "name") Optional<String> optionalName) {
        return optionalName
                .map(this::getBooksByName)
                .orElseGet(this::getAllBooks);
    }

    private List<Book> getAllBooks() {
       return  library.getBooks();
    }

    private List<Book> getBooksByName(String name) {
        return library.
                getBooks()
                .stream()
                .filter(book -> Objects.equals(book.getName(), name))
                .collect(Collectors.toList());
    }
}
