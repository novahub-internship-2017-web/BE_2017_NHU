package nhu.novahub.assignment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment4.dao.BookRepository;
import nhu.novahub.assignment4.entities.Book;

@Service
@Transactional
public class BookService{
  
  @Autowired
  private BookRepository bookRepository;
  
  public Page<Book> findAllByEnabled(int enabled,Pageable pageable){
    return bookRepository.findAllByEnabled(enabled,pageable);
  }
  
  public Page<Book> findAll(Pageable pageable){
    return bookRepository.findAll(pageable);
  }
  
  public Page<Book> searchByTitle(String title,Pageable pageable){
	  return bookRepository.searchByTitle(title, pageable);
  }
  
  public Book findById(int id) {
    return bookRepository.findById(id);
  }
  
  public Book addBook(Book book) {
    Book newBook = bookRepository.save(book);
    return newBook;
  }
  
  public void updateBook(Book book) {
    bookRepository.save(book);
  }
  
  public Page<Book> findAllByUserId(int userId,Pageable pageable){
    return bookRepository.findAllByUserId(userId,pageable);
  } 
}