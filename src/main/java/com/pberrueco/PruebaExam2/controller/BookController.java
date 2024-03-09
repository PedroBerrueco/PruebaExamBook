package com.pberrueco.PruebaExam2.controller;

import com.pberrueco.PruebaExam2.model.Book;
import com.pberrueco.PruebaExam2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping // GET AL LIST
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/{id}") //GET ONE BY ID
    public ResponseEntity<Optional<Book>> getById(@PathVariable Long id) {
        Optional<Book> book = bookService.getOne(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name") //GET ONE BY NAME
    public ResponseEntity<List<Book>> searchName(@RequestParam String name) {
        List<Book> books = bookService.searchByName(name);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/integer") //GET ONE BY INTEGER
    public ResponseEntity<List<Book>> searchInteger(@RequestParam Integer integer) {
        List<Book> books = bookService.searchByInteger(integer);
        return ResponseEntity.ok(books);
    }

    @PostMapping //POST ONE
    public ResponseEntity<Book> save(@RequestBody Book book){
        Book bookNew = bookService.saveOne(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookNew);
    }

    @PutMapping("/{id}") //PUT ONE BY ID
    public ResponseEntity<Book> update(@RequestBody Book book){
        Book bookNew = bookService.updateOne(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookNew);
    }

    @DeleteMapping("/{id}") //DELETE ON BY ID
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bookService.deleteOne(id);
        String mensaje = id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }

}
