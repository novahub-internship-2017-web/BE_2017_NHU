package nhu.novahub.assignment4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Book")
public class Book {
  
  @Id
  private int id;
  private String title;
  private String author;
  private String description;
  private String created_at;
  private String updated_at;
  private String image = "coverBook.jpg";
  private int enabled;
  private int user_id;
  private int removed;
  
  
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
  public String getCreated_at() {
    return created_at;
  }
  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }
  public String getUpdated_at() {
    return updated_at;
  }
  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
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
  public int getUser_id() {
    return user_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public int getRemoved() {
    return removed;
  }
  public void setRemoved(int removed) {
    this.removed = removed;
  }
  
  
}
