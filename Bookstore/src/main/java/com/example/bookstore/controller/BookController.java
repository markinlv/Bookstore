package com.example.bookstore.controller;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
    
    @GetMapping("/list")
    public String list(ModelMap model){
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/new")
        public String newBook (Book book){
        return "book/form";
    }

    @PostMapping("/save")
    public String save (Book book){
        bookRepository.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/delete/{code}")
    public String delete(@PathVariable("code") Long code) {
        Optional<Book> book = bookRepository.findById(code);
        bookRepository.delete(book.get());
        return "redirect:/books/list";
    }

    @GetMapping("/edit/{code}")
    public String edit (@PathVariable("code") Long code, ModelMap model){
        Optional<Book> optional = bookRepository.findById(code);
    model.addAttribute("book", optional.get());
    return "book/form";
    }
}
