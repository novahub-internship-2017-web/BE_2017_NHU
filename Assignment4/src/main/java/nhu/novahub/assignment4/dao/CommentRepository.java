package nhu.novahub.assignment4.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nhu.novahub.assignment4.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment , Long>{
	
 	
  public List<Comment> findAllByBookIdOrderByIdDesc(int bookId);
}