package com.example.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/faq")
    public String faq(){
        Book b = new Book();

        return "faq";
    }

}
