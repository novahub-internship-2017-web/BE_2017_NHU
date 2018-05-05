package nhu.novahub.assignment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nhu.novahub.assignment4.dao.CommentRepository;
import nhu.novahub.assignment4.entities.Comment;

@Service
@Transactional
public class CommentService{
  
  @Autowired
  private CommentRepository commentRepository;
  
  public List<Comment> findAllByBookId(int bookId){
    return commentRepository.findAllByBookIdOrderByIdDesc(bookId);
  }
  
  public Comment addComment(Comment comment) {
    return  commentRepository.save(comment);
  }
}