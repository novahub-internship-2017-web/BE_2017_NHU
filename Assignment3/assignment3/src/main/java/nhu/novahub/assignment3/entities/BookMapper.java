package nhu.novahub.assignment3.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book>{
	
	  public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Book book = new Book();
		  	book.setId(rs.getInt("id"));
		  	book.setTitle(rs.getString("title"));
		  	book.setAuthor(rs.getString("author"));
		  	//chuyen thoi gian theo dinh dang muon hien thi
		  	String timeDB = rs.getString("created_at");
		  	String timeFormated = "";
		  	Date date;
		  	SimpleDateFormat format_to_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat format_to_string= new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	        try {
	            date = format_to_date.parse(timeDB);
	            timeFormated = format_to_string.format(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		  	book.setCreatedAt(timeFormated);
		  	//
		  	timeDB = rs.getString("updated_at");
		  	format_to_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			format_to_string= new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	        try {
	            date = format_to_date.parse(timeDB);
	            timeFormated = format_to_string.format(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		  	book.setUpdatedAt(timeFormated);
		  	book.setUserId(rs.getInt("user_id"));
		  	book.setPicture(rs.getString("picture"));
		  	book.setDescription(rs.getString("description"));
		    return book;
		  }
}
