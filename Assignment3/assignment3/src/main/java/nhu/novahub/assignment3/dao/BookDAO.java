package nhu.novahub.assignment3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import nhu.novahub.assignment3.entities.Book;
import nhu.novahub.assignment3.entities.BookMapper;
@Repository
public class BookDAO {
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	 
	  public List<Book> findAll() {
	    String sql = "SELECT * FROM book";
	    return jdbcTemplate.query(sql, new BookMapper());
	  }
	  
	  public List<Book> findAllByUserId(int userId){
		  String sql = "SELECT * FROM book WHERE user_id='"+ userId +"'";
		  return jdbcTemplate.query(sql, new BookMapper());
	  } 
	  
	  public void add(Book book) {
		/*String sql = "INSERT INTO book (title,author,created_at,updated_at,user_id,picture,description)"
		  		+ " values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,book.getTitle(),book.getAuthor(),book.getCreatedAt(),
				book.getUpdatedAt(),book.getUserId(),book.getPicture(),book.getDescription());*/
		String sql = "INSERT INTO book (title,author,created_at,updated_at,user_id,picture,description)"
		  		+ " values ('"+ book.getTitle() +"','"+book.getAuthor()+"',"
		  				+ "'"+book.getCreatedAt()+"','"+book.getUpdatedAt()+"',"
		  						+ "'"+book.getUserId()+"','"+book.getPicture()+"',"
		  								+ "'"+book.getDescription()+"')";
		jdbcTemplate.update(sql);
	  }
	  
	  public Book findById(int id) {
		  String sql = "SELECT * FROM book WHERE id = '"+ id+"' ";
		  return jdbcTemplate.queryForObject(sql, new BookMapper());
	  }
	  
	  public void edit(Book book) {
		  String sql = "UPDATE book SET title='"+ book.getTitle() +"', "
		  							+ "author='"+ book.getAuthor() +"', "
		  							+ "updated_at='"+ book.getUpdatedAt() +"', "
		  							+ "picture='"+ book.getPicture() +"', "
		  							+ "description='"+ book.getDescription() +"' "
		  							+ "WHERE id='" + book.getId() + "'";
		  jdbcTemplate.update(sql);
	  }
	  
	  public void delete(int id) {
		  String sql = "DELETE FROM book WHERE id="+id;
		  jdbcTemplate.update(sql);
	  }
	  
	  public void deleteByUserId(int userId) {
		  String sql = "DELETE FROM book WHERE user_id="+userId;
		  jdbcTemplate.update(sql);
	  }
	  
	  public List<Book> searchByField(String field,String keyword){
		  String sql = "select * from book where "+field+" like '%"+ keyword +"%'";
		  return jdbcTemplate.query(sql, new BookMapper());
	  }
	  
	  public List<Book> searchAll(String keyword){
		  String sql = "select * from book where title like '%"+ keyword +"%'\n" + 
		  									"or author like '%"+ keyword +"%'";
		  return jdbcTemplate.query(sql, new BookMapper());
	  }
}
