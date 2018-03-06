package nhu.novahub.assignment3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nhu.novahub.assignment3.entities.Book;
import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.UserService;
import nhu.novahub.assignment3.service.BookService;

@Controller
@SessionAttributes("currentSessionUsername")
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	/*
	@RequestMapping(value="booksList", method = RequestMethod.GET)
	public ModelAndView booksList(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}
		model.addObject("booksList", bookService.findAll());
		model.setViewName("booksList");
		return model;
	}*/
	
	@RequestMapping(value="booksListUser", method = RequestMethod.GET)
	public ModelAndView booksListUser(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
	//	 model.addObject("user", new User());
		 model.setViewName("redirect:../login");
		}else {
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		List<Book> booksList = bookService.findAllByUserId(user_id);
			if(booksList.isEmpty()) {
				model.setViewName("redirect:./addForm");
			}else {
				model.addObject("booksList", booksList);
				model.setViewName("booksList");
			}
		}
		return model;
	}
	
	@RequestMapping(value="addForm", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView bookCreation(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}
		model.addObject("book", new Book());
		model.setViewName("bookCreation");
		return model;
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("book") Book book,ModelAndView model, 
			/*@RequestParam MultipartFile fileUpload,*/
			@ModelAttribute("currentSessionUsername") String username){
		int user_id = userService.findByUsername(username).getId();
		book.setUserId(user_id);
		
		// directory to upload file
		/*String uploadingdir = servletContext.getRealPath("/")+"/resources/images/";
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setCreatedAt(timeUpdateString);
		book.setUpdatedAt(timeUpdateString);
		SimpleDateFormat timeFormat2 = new SimpleDateFormat("HHmmssddMMyyyy");
		String imageName = timeFormat2.format(timeUpdate.getTime());
		//upload image
		try {
			File file = new File(uploadingdir, imageName);
		    fileUpload.transferTo(file);
		}catch (Exception e) {
		      e.printStackTrace();
		      System.out.print("up failed");
		}
		book.setPicture(imageName);*/
		
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setCreatedAt(timeUpdateString);
		book.setUpdatedAt(timeUpdateString);
		bookService.add(book);
		model.addObject("booksList", bookService.findAll());
		model.setViewName("booksList");
		return model;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView bookDetail(@RequestParam("id") String id, ModelAndView model) {
		Book book = bookService.findById(Integer.parseInt(id));
		model.addObject("book", book);
		model.setViewName("bookDetails");
		return model;
	}
	
	@RequestMapping(value="editForm", method = RequestMethod.GET)
	public ModelAndView bookEdition(@ModelAttribute("currentSessionUsername") String username,
					@RequestParam("id") String id,ModelAndView model) {	
		int user_id = userService.findByUsername(username).getId();
		Book book = bookService.findById(Integer.parseInt(id));
		if(book.getUserId() == user_id) {
			model.addObject("book", book);
			model.setViewName("bookEdition");	
		}else {
			model.addObject("msg", "Bạn không có quyền chỉnh sửa");
			model.addObject("book", book);
			model.setViewName("bookDetails");
		}
		return model;
	}
	
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public ModelAndView editBook(@ModelAttribute("book") Book book,
			ModelAndView model/*,	@RequestParam MultipartFile fileUpload*/) {	
		// directory to upload file
		/*String uploadingdir = servletContext.getRealPath("/")+"/resources/images/";
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("HH:mm:ss dd/MM/yyyy"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setUpdatedAt(timeUpdateString);
		SimpleDateFormat timeFormat2 = new SimpleDateFormat("HHmmssddMMyyyy");
		String imageName = timeFormat2.format(timeUpdate.getTime());
		//upload image
		try {
			File file = new File(uploadingdir, imageName);
		    fileUpload.transferTo(file);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("up failed");
		}
		book.setPicture(imageName);*/
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setUpdatedAt(timeUpdateString);
		bookService.edit(book);
		Book bookEdited = bookService.findById(book.getId());
		model.addObject("book", bookEdited);
		model.setViewName("bookDetails");
		return model;
	}
	@RequestMapping(value="delete/{id}")
	public String deleteBook(@PathVariable ("id") String id, final RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		int bookId = Integer.parseInt(id);
		Book book = bookService.findById(bookId);
		if(book.getUserId() == user_id) {
			bookService.delete(bookId);
			redirectAttributes.addFlashAttribute("msg", "Đã xóa thành công");
			//model.addObject("msg", "Đã xóa thành công");
			//model.addObject("booksList", bookService.findAll());
			//model.setViewName("booksList");
		}else {
			redirectAttributes.addFlashAttribute("msg", "Bạn không có quyền xóa");
			/*model.addObject("msg", "Bạn không có quyền xóa");
			model.addObject("booksList", bookService.findAll());
			model.setViewName("booksList");*/
		}
		return "redirect:../booksList";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	  public ModelAndView search(@RequestParam String keyword,
			  @RequestParam String searchBy){
	    ModelAndView model = new ModelAndView();
	    List<Book> booksList;
	    if(searchBy.equals("all_field")) {
	    	booksList = bookService.searchAll(keyword);
	    }else {
	    	booksList = bookService.searchByField(searchBy, keyword);
	    }
	    if(booksList.isEmpty()) {
	    	model.addObject("msg", "Không tìm thấy kết quả với từ khóa '<i>"+keyword+"</i>'");
	    	model.addObject("css","display:none");
	    }else {
	    	model.addObject("msg", "Kết quả tìm kiếm với từ khóa '<i>"+keyword+"</i>'");
	    }	    
	    model.addObject("booksList", booksList);
	    model.setViewName("booksList");
	    return model;
	   
	  }
}
