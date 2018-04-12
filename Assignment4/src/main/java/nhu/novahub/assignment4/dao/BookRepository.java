package nhu.novahub.assignment4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.Book;

public interface BookRepository extends CrudRepository<Book , Long>{
  
  public List<Book> findAll();
  
  /*  
  @Query("select b from Book b where b.enabled=0")
  public List<Book> findAllDisabled();*/
  
  public Book findById(int id);
  
  @Query("select b from Book b where b.enabled=?1 and b.removed=0")
  public List<Book> findAllByEnabled(int enabled);
  
  @Query("select b from Book b where b.userId=?1 and b.removed=0")
  public List<Book> findAllByUserId(int userId);
}