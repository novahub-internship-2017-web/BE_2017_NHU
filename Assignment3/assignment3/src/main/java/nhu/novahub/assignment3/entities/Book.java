package nhu.novahub.assignment3.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private String created_at;
	private String updated_at;
	private int user_id;
	private String picture = "bookAva.jpg";
	private String description;
	
	public Book() {
		
	}
	
	public Book(String title,String author,String created_at,String updated_at,int user_id) {
		this.title = title;
		this.author = author;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user_id = user_id;
	}
	
	public Book(String title,String author,String created_at,String updated_at,int user_id,
			String picture, String description) {
		this.title = title;
		this.author = author;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user_id = user_id;
		this.picture = picture;
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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

	public String getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(String created_at) {
		
        this.created_at = created_at;
	}

	public String getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(String updated_at) {
		
		this.updated_at = updated_at;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
