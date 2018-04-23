package nhu.novahub.assignment4.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhu.novahub.assignment4.entities.Book;
import nhu.novahub.assignment4.entities.Response;
import nhu.novahub.assignment4.entities.User;
import nhu.novahub.assignment4.service.BookService;
import nhu.novahub.assignment4.service.RoleService;
import nhu.novahub.assignment4.service.UserService;

@RestController
@RequestMapping("/api/book")
public class BookController {
  @Autowired
  private BookService bookService;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  
  Authentication authentication;
  
  @PostMapping("/add")
  public Response addBook(@RequestBody Book newBook,Principal principal) {
    User currentUser =  userService.findByEmail(principal.getName());
    newBook.setUserId(currentUser.getId());
    Date timeUpdate=new Date(System.currentTimeMillis()); 
    newBook.setCreatedAt(timeUpdate);
    newBook.setUpdatedAt(timeUpdate);
    Book newBookAdd = bookService.addBook(newBook);
    Response response = new Response("Thêm sách thành công",newBookAdd);
    return response;
  }
  @GetMapping(value= {"/all"})
  public Response getAll(Pageable pageable) {
	  authentication = SecurityContextHolder.getContext().getAuthentication();
	  Response response = new Response();
	  if(authentication.toString().contains("ROLE_ADMIN") || 
		 authentication.toString().contains("ROLE_SUPER_ADMIN") ) {
        try {
        	Page<Book> books = bookService.findAll(pageable);
        	response.setData(books);
   		 	response.setStatus("Có dữ liệu");
		}catch(Exception e) {
			
		}
	    }else {
	    	Page<Book> books = bookService.findAllByEnabled(1,pageable);  
	    	response.setData(books);
			response.setStatus("Có dữ liệu");
	    }
	  
    return response;
  }
  
  @GetMapping("/all/byUser")
  public Response getAllByIdUser(Pageable pageable) {
	authentication = SecurityContextHolder.getContext().getAuthentication();
	Response response = new Response();
    User currentUser =  userService.findByEmail(authentication.getName());
    int idCurrentUser = currentUser.getId();
    Page<Book> books = bookService.findAllByUserId(idCurrentUser,pageable);
    response.setData(books);
    return response;
  }
  
  @GetMapping(value= {"/search"})
  public Response search(@RequestParam String keyword,
		  				 Pageable pageable) {
	  Page<Book> books = bookService.searchByTitle(keyword, pageable);
	  Response response = new Response();
	  if(books.hasContent()) {
		 response.setData(books);
		 response.setStatus("Kết quả tìm kiếm với từ khóa '"+ keyword +"'" );
	  }else {
		  response.setStatus("Không có kết quả");
	  }
    return response;
  }
     
 
  
  @GetMapping("/{id}")
  public Book getBookById(@PathVariable(value = "id") int bookId) {
    return bookService.findById(bookId);
  }
  
  @PostMapping("/enabled/{id}")
  public Response changeEnabled(@PathVariable(value = "id") int bookId,@RequestParam int status,
            Principal principal) {
    authentication = SecurityContextHolder.getContext().getAuthentication();
    Response response  = new Response();
    if(authentication.toString().contains("ROLE_ADMIN") || 
   		 authentication.toString().contains("ROLE_SUPER_ADMIN") ) {
    	Book book = bookService.findById(bookId);
        book.setEnabled(status);
        try {
        	bookService.updateBook(book);
        	response.setStatus("Bạn vừa thay đổi trạng thái của sách");
		}catch(Exception e) {
			response.setStatus("Lỗi! Không thay đổi được");
		}
    }else {
    	response.setStatus("Bạn không có quyền thể thay đổi trạng thái");
    }
   
    return response;
  }
  
  @PutMapping("/update/{id}")
  public Book updateBook(@PathVariable int id,@RequestBody Book updateBook,
                       Principal principal) {
    User currentUser =  userService.findByEmail(principal.getName());
    int idCurrentUser = currentUser.getId(); 
    Book oldBook = bookService.findById(id);
    if(authentication.toString().contains("ROLE_ADMIN") || 
       authentication.toString().contains("ROLE_SUPER_ADMIN") || (
       authentication.toString().contains("ROLE_USER") && oldBook.getUserId() == idCurrentUser)) {
      oldBook.setTitle(updateBook.getTitle());
      oldBook.setAuthor(updateBook.getAuthor());
      oldBook.setDescription(updateBook.getDescription());
      Date timeUpdate=new Date(System.currentTimeMillis()); 
      oldBook.setUpdatedAt(timeUpdate);
      bookService.updateBook(oldBook);
      return bookService.findById(id);
    }else {
      return oldBook;
    }
  }
  
  @DeleteMapping("/delete/{id}")
  public Response deleteBook(@PathVariable(value = "id") int bookId) {
	authentication = SecurityContextHolder.getContext().getAuthentication();
	User currentUser =  userService.findByEmail(authentication.getName());
	int idCurrentUser = currentUser.getId();
	Book book = bookService.findById(bookId);
	Response response = new Response();
	if(authentication.toString().contains("ROLE_ADMIN") || 
	   authentication.toString().contains("ROLE_SUPER_ADMIN") || (
	   authentication.toString().contains("ROLE_USER") && book.getUserId() == idCurrentUser)) {
	    book.setRemoved(1);
	    try {
	    	bookService.updateBook(book);
	    	response.setStatus("Xóa thành công");
	    }catch (Exception e) {
	    	response.setStatus("Lỗi! Không xóa đươc.");
	    }
	  }else {
		  response.setStatus("Bạn không có quyền xóa");
	  }
    return response;
  }
}
