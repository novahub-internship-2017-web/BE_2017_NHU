package nhu.novahub.assignment4.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.Book;

public interface BookRepository extends CrudRepository<Book , Long>{
  public List<Book> findAll();
  public Book findById(int id);
}
