package nhu.novahub.assignment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment4.dao.BookRepository;
import nhu.novahub.assignment4.entities.Book;

@Service
@Transactional
public class BookService{
  
  @Autowired
  private BookRepository bookRepository;
  
  public List<Book> findAllByEnabled(int enabled){
    return bookRepository.findAllByEnabled(enabled);
  }
  
  public List<Book> findAll(){
    return bookRepository.findAll();
  }
  
  public Book findById(int id) {
    return bookRepository.findById(id);
  }
  
  public void addBook(Book book) {
    bookRepository.save(book);
  }
  
  public void updateBook(Book book) {
    bookRepository.save(book);
  }
  
  public List<Book> findAllByUserId(int userId){
    return bookRepository.findAllByUserId(userId);
  } 
}