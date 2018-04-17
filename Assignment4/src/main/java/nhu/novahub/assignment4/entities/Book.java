package nhu.novahub.assignment4.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*; 

@Entity
@Table (name = "Book")
public class Book {
  
  @Id
  @Column(name = "id")
  private int id;
  
  @Column(name = "title")
  private String title;
  
  @Column(name = "author")
  private String author;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "created_at")
  @JsonFormat
  (shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss dd-MM-yyyy")
  private Date createdAt;
  
  @Column(name = "updated_at")
  private String updatedAt;
  
  @Column(name = "image")
  private String image = "coverBook.jpg";
  
  @Column(name = "enabled")
  private int enabled;
  
  @Column(name = "user_id")
  private int userId;
  
  @Column(name = "removed")
  private int removed;
  
  public Book() {}
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
  public String getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }
  public int getEnabled() {
    return enabled;
  }
  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }
  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public int getRemoved() {
    return removed;
  }
  public void setRemoved(int removed) {
    this.removed = removed;
  }
  
  
}
