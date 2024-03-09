package com.pberrueco.PruebaExam2.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "fav_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) // Lo ponemos sobre las columnas que no queramos que sean nulas.
    private String name;
    private String tipe;
    @Column(nullable = false)
    private Integer year;
}
