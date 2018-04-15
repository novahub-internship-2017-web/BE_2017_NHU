package nhu.novahub.assignment4.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Comment")
public class Comment {
  
  @Id
  @Column(name = "id")
  private int id;
  
  @Column(name = "message")
  private String message;
  
  @Column(name = "user_id")
  private int userId;
  
  @Column(name = "book_id")
  private int bookId;
  
  @Column(name = "created_at")
  private Date createdAt;
  
  @Column(name = "updated_at")
  private Date updatedAt;
  
  public Comment() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
  
  
}