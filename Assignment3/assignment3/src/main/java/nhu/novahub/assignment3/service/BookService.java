package nhu.novahub.assignment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhu.novahub.assignment3.dao.BookDAO;
import nhu.novahub.assignment3.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;

	public List<Book> findAll(){
		return bookDAO.findAll();
	}
	
	public List<Book> findAllByUserId(int id){
		return bookDAO.findAllByUserId(id);
	}
	
	public void add(Book book) {
		bookDAO.add(book);
	}
	
	public Book findById (int id) {
		return bookDAO.findById(id);
	}
	
	public void edit(Book book) {
		bookDAO.edit(book);
	}
	
	public void delete(int id) {
		bookDAO.delete(id);
	}
	
	public void deleteByUserId(int userId) {
		bookDAO.deleteByUserId(userId);
	}
	
	public List<Book> searchByField(String field,String keyword){
		return bookDAO.searchByField(field, keyword);
	}
	
	public List<Book> searchAll(String keyword){
		return bookDAO.searchAll(keyword);
	}
}
