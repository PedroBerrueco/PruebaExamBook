package com.pberrueco.PruebaExam2.repository;

import com.pberrueco.PruebaExam2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCase(String name); //Para buscar la universidad por nombre***
    List<Book> findBooksByYearOrderByName(Integer year); //Para buscar por Integer
}
