package nhu.novahub.assignment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.BookRepository;
import nhu.novahub.assignment4.entities.Book;

@RestController
@RequestMapping("/api/book")
public class BookController {
  @Autowired
  private BookRepository bookRepository;
  
  @GetMapping("/all")
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
  
  @GetMapping("/{id}")
  public Book getBookById(@PathVariable(value = "id") int bookId) {
    return bookRepository.findById(bookId);
  }
}
