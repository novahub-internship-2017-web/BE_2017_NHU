package nhu.novahub.assignment4.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import nhu.novahub.assignment4.entities.Book;

public interface BookRepository extends CrudRepository<Book , Long>{
  
  public Page<Book> findAll(Pageable pageable);
  
  public Book findById(int id);
  
  @Query("select b from Book b where b.title like %:title% and b.removed=0")
  public Page<Book> searchByTitle(@Param("title") String title,Pageable pageable); 
  
  @Query("select b from Book b where b.enabled=?1 and b.removed=0")
  public Page<Book> findAllByEnabled(int enabled,Pageable pageable);
  
  @Query("select b from Book b where b.userId=?1 and b.removed=0")
  public Page<Book> findAllByUserId(int userId,Pageable pageable);
}