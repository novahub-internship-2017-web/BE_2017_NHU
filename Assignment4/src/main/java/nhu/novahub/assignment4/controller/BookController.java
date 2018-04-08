package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.dao.BookRepository;
import nhu.novahub.assignment4.dao.UserRepository;
import nhu.novahub.assignment4.entities.Book;
import nhu.novahub.assignment4.entities.User;

@RestController
@RequestMapping("/api/book")
public class BookController {
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private UserRepository userRepository;
  
  @PostMapping("/add")
  public List<Book> postMethod(@RequestBody Book newBook,Principal principal) {
    User currentUser =  userRepository.findByEmail(principal.getName());
    newBook.setUser_id(currentUser.getId());
    Date timeUpdate=new Date(System.currentTimeMillis()); 
    SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    String timeUpdateToString=timeFormat.format(timeUpdate.getTime());
    newBook.setCreated_at(timeUpdateToString);
    newBook.setUpdated_at(timeUpdateToString);
    bookRepository.save(newBook);
    return bookRepository.findAll();
  }
  
  @GetMapping("/all")
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
  
  @GetMapping("/all/enabled")
  public List<Book> getAllEnabledBooks() {
    return bookRepository.findAllEnabled();
  }
  
  @GetMapping("/all/disabled")
  public List<Book> getAllDisabledBooks() {
    return bookRepository.findAllDisabled();
  }
  
  @GetMapping("/{id}")
  public Book getBookById(@PathVariable(value = "id") int bookId) {
    return bookRepository.findById(bookId);
  }
  
  @PostMapping("/enabled/{id}")
  public void changeEnabled(@PathVariable(value = "id") int bookId,@RequestParam int check) {
    if(check == 1) { 
       check = 0;
    }else {
      check = 1;
    }
    Book book = bookRepository.findById(bookId);
    book.setEnabled(check);
    bookRepository.save(book);
  }
  @PutMapping("/update/{id}")
  public Book updateBook(@PathVariable int id,
                  @RequestBody Book updateBook) {
    Book oldBook = bookRepository.findById(id);
    oldBook.setTitle(updateBook.getTitle());
    oldBook.setAuthor(updateBook.getAuthor());
    oldBook.setDescription(updateBook.getDescription());
    Date timeUpdate=new Date(System.currentTimeMillis()); 
    SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    String timeUpdateToString=timeFormat.format(timeUpdate.getTime());
    oldBook.setUpdated_at(timeUpdateToString);
    return bookRepository.save(oldBook);
  }
  
  
}
