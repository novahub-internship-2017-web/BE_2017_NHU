package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.entities.Comment;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.CommentService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
  
  @Autowired
  private CommentService commentService;
  @Autowired
  private UserService userService;
  
  @GetMapping("/all/{bookId}")
  public List<Comment> getAllByBookId(@PathVariable(value = "bookId") int bookId) {
    return commentService.findAllByBookId(bookId);
  }
  
  @PostMapping("/add/{bookId}")
  public Comment postMethod(@RequestBody Comment newComment,Principal principal,
                            @PathVariable(value = "bookId") int bookId) {
    User currentUser =  userService.findByEmail(principal.getName());
    newComment.setUserId(currentUser.getId());
    newComment.setBookId(bookId);
    Date timeUpdate=new Date(System.currentTimeMillis()); 
    newComment.setCreatedAt(timeUpdate);
    newComment.setUpdatedAt(timeUpdate);
    return commentService.addComment(newComment);
  }
}