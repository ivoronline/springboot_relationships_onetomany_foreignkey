package com.ivoronline.springboot_relationships_onetomany_foreignkey.controllers;

import com.ivoronline.springboot_relationships_onetomany_foreignkey.entities.Author;
import com.ivoronline.springboot_relationships_onetomany_foreignkey.entities.Book;
import com.ivoronline.springboot_relationships_onetomany_foreignkey.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
public class MyController {

  @Autowired
  AuthorRepository authorRepository;

  @ResponseBody
  @RequestMapping("/addAuthor")
  public String addAuthor() {

    //CREATE BOOK ENTITIES
    Book    book1        = new Book();
            book1.title  = "Book about dogs";

    Book    book2        = new Book();
            book2.title  = "Book about cats";

    //CREATE AUTHOR ENTITY
    Author  author       = new Author();
            author.name  = "John";
            author.age   = 20;
            author.books = new HashSet<Book>();
            author.books.add(book1);
            author.books.add(book2);

    //STORE AUTHOR/BOOKS ENTITIES
    authorRepository.save(author);

    //RETURN SOMETHING TO BROWSER
    return "Author & Books were stored into DB";

  }

}
