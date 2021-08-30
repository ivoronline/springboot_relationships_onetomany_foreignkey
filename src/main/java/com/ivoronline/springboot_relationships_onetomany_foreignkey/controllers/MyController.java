package com.ivoronline.springboot_relationships_onetomany_foreignkey.controllers;

import com.ivoronline.springboot_relationships_onetomany_foreignkey.entities.Author;
import com.ivoronline.springboot_relationships_onetomany_foreignkey.entities.Book;
import com.ivoronline.springboot_relationships_onetomany_foreignkey.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;

@RestController
public class MyController {

  @Autowired AuthorRepository authorRepository;

  //===========================================================================
  // ADD AUTHOR BOOKS
  //===========================================================================
  @RequestMapping("/AddAuthorBooks")
  public String addAuthorBooks() {

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

  //===========================================================================
  // GET AUTHOR BOOKS
  //===========================================================================
  @RequestMapping("GetAuthorBooks")
  public String getAuthorBooks() {

    //GET AUTHOR
    Author author = authorRepository.findById(1).get();

    //GET BOOKS
    String   books         = "";
    Iterator booksIterator = author.books.iterator();
    while(booksIterator.hasNext()) {
      Book book = (Book) booksIterator.next();
      books += book.title + ", ";
    }

    //RETURN SOMETHING
    return author.name + " has written: " + books;

  }

}
