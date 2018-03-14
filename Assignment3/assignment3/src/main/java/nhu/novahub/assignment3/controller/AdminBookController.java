package nhu.novahub.assignment3.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nhu.novahub.assignment3.entities.Book;
import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.UserService;
import nhu.novahub.assignment3.service.BookService;
import nhu.novahub.assignment3.service.RoleService;

@Controller
@SessionAttributes("currentSessionUsername")
@RequestMapping("admin/book")
public class AdminBookController {
	
	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	RoleService roleService;
	
	
	@RequestMapping(value="booksList", method = RequestMethod.GET)
	public ModelAndView booksList(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}
		String username = (String) session.getAttribute("currentSessionUsername");
		User userCurrent = userService.findByUsername(username);
		String role = roleService.findById(userCurrent.getId()).getRolename();
		if(role.contains("admin")) {
			model.addObject("booksList", bookService.findAll());
			model.setViewName("admin/booksList");
			if(role.equals("admin")) {
				model.addObject("css_del","display:none");
			}
		}else {
			model.addObject("error", "Bạn không có quyền truy cập");
			model.setViewName("errorPage");
		}
		return model;
	}
	
	@RequestMapping(value="booksListUser", method = RequestMethod.GET)
	public ModelAndView booksListUser(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
		 model.addObject("user", new User());
		 model.setViewName("loginPage");
		}else {
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		List<Book> booksList =  bookService.findAllByUserId(user_id);
		if(booksList.isEmpty()) {
			model.addObject("msg", "Kho sách của bạn trống");
		} 
		model.addObject("booksList", booksList);
		model.setViewName("admin/booksList");
		}
		return model;
	}
	
	@RequestMapping(value="{id}/detail", method = RequestMethod.GET)
	public ModelAndView bookDetail(@PathVariable("id") int id, ModelAndView model) {
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}else{
			String username = (String)session.getAttribute("currentSessionUsername");
			int user_id = userService.findByUsername(username).getId();
			String role = roleService.findById(user_id).getRolename();
			if(role.equals("user")) {
				model.addObject("error", "Bạn không có quyền truy cập");
				model.setViewName("errorPage");
				return model;
			}else {
				Book book = bookService.findById(id);
				model.addObject("book", book);
				model.setViewName("admin/bookDetails");
				return model;
			}
		}
		
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id,
		final RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("currentSessionUsername");
		User userCurrent = userService.findByUsername(username);
		String role = roleService.findById(userCurrent.getId()).getRolename();
		int user_id = userCurrent.getId();
		int bookId = id;
		Book book = bookService.findById(bookId);
		if(book.getUserId() == user_id || role.equals("admin_default")) {
			bookService.delete(bookId);
			redirectAttributes.addFlashAttribute("msg", "Đã xóa thành công");
		}else {
			redirectAttributes.addFlashAttribute("msg", "Bạn không có quyền xóa");
		}
		return "redirect:../booksList";
	}
	
	@RequestMapping(value="addForm", method = RequestMethod.GET)
	public ModelAndView bookCreation(ModelAndView model) {	
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}
		model.addObject("book", new Book());
		model.setViewName("admin/bookCreation");
		return model;
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("book") Book book,ModelAndView model,
			@ModelAttribute("currentSessionUsername") String username,
			@RequestParam MultipartFile fileUpload,HttpServletRequest request){
		int user_id = userService.findByUsername(username).getId();
		book.setUserId(user_id);
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setCreatedAt(timeUpdateString);
		book.setUpdatedAt(timeUpdateString);
		//upload image
		String nameFile = fileUpload.getOriginalFilename();
		String dirFile = request.getSession().getServletContext().getRealPath("/")+"resources/images";
		File fileDir = new File(dirFile);
		if(!"".equals(nameFile)){
		if(!(fileUpload.getContentType().toLowerCase().equals("image/jpg") 
			|| fileUpload.getContentType().toLowerCase().equals("image/jpeg") 
			 || fileUpload.getContentType().toLowerCase().equals("image/png"))){
			 model.addObject("error", "Chỉ up loại file ảnh");
			 model.addObject("book",book);
			 model.setViewName("admin/bookCreation");
			 return model;
		    }
			if(fileUpload.getSize() >= 3000000) {
				model.addObject("error", "Dung lượng file không quá 3MB");
				model.addObject("book",book);
				model.setViewName("admin/bookCreation");
				return model;
			}
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			String typeOfFile = nameFile.substring(nameFile.lastIndexOf("."));
			SimpleDateFormat timeFormat2 = new SimpleDateFormat("HHmmssddMMyyyy");
			nameFile = timeFormat2.format(timeUpdate.getTime());
			try {
				fileUpload.transferTo(new File(fileDir+File.separator+nameFile+typeOfFile));
				System.out.println("Upload file thành công!"+fileDir+File.separator+nameFile+typeOfFile);
				book.setPicture(nameFile+typeOfFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		//		
		bookService.add(book);
		model.addObject("booksList", bookService.findAll());
		model.setViewName("admin/booksList");
		return model;
	}
	
	@RequestMapping(value="editForm", method = RequestMethod.GET)
	public ModelAndView bookEdition(@RequestParam("id") String id,ModelAndView model) {	
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		Book book = bookService.findById(Integer.parseInt(id));
		model.addObject("book", book);
		model.setViewName("admin/bookEdition");	
		return model;
	}
	
	@RequestMapping(value="edit", method = RequestMethod.POST)
	public ModelAndView editBook(@ModelAttribute("book") Book book,
			ModelAndView model,@RequestParam MultipartFile fileUpload,HttpServletRequest request) {	
		Date timeUpdate=new Date(System.currentTimeMillis()); 
		SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String timeUpdateString=timeFormat.format(timeUpdate.getTime());
		book.setUpdatedAt(timeUpdateString);
		//upload image
		String nameFile = fileUpload.getOriginalFilename();
		String dirFile = request.getSession().getServletContext().getRealPath("/")+"resources/images";
		File fileDir = new File(dirFile);
		if(!"".equals(nameFile)){
			if(!(fileUpload.getContentType().toLowerCase().equals("image/jpg") 
		            || fileUpload.getContentType().toLowerCase().equals("image/jpeg") 
		            || fileUpload.getContentType().toLowerCase().equals("image/png"))){
			 model.addObject("error", "Chỉ up loại file ảnh");
			 model.addObject("book",book);
			 model.setViewName("admin/bookEdition");
			 return model;
		    }
			if(fileUpload.getSize() >= 3000000) {
				model.addObject("error", "Dung lượng file không quá 3MB");
				model.addObject("book",book);
				model.setViewName("admin/bookEdition");
				return model;
			}
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			String typeOfFile = nameFile.substring(nameFile.lastIndexOf("."));
			SimpleDateFormat timeFormat2 = new SimpleDateFormat("HHmmssddMMyyyy");
			nameFile = timeFormat2.format(timeUpdate.getTime());
			try {
				fileUpload.transferTo(new File(fileDir+File.separator+nameFile+typeOfFile));
				System.out.println("Upload file thành công!"+fileDir+File.separator+nameFile+typeOfFile);
				book.setPicture(nameFile+typeOfFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		//
		bookService.edit(book);
		Book bookEdited = bookService.findById(book.getId());
		model.addObject("book", bookEdited);
		model.setViewName("admin/bookDetails");
		return model;
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
	    model.setViewName("admin/booksList");
	    return model;
	   
	  }
}
