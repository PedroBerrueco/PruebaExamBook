package com.pberrueco.PruebaExam2.service;

import com.pberrueco.PruebaExam2.model.Book;
import com.pberrueco.PruebaExam2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() { return bookRepository.findAll(); }
    public Optional<Book> getOne(Long id){
        return bookRepository.findById(id);
    }
    public Book saveOne(Book book){
        return bookRepository.save(book);
    }
    public Book updateOne(Book book){
        return bookRepository.save(book);
    }
    public void deleteOne(Long id){
        bookRepository.deleteById(id);
    }
    public List<Book> searchByName(String name){ return bookRepository.findByNameContainingIgnoreCase(name);}
    public List<Book> searchByInteger(Integer integer){ return bookRepository.findBooksByYearOrderByName(integer);}

}
