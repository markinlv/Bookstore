package com.example.bookstore.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false, length = 60)
    private String author;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name ="publication_date ", nullable = false)
    private LocalDate publicationDate;
}
