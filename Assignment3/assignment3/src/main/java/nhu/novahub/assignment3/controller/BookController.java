package nhu.novahub.assignment3.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nhu.novahub.assignment3.entities.Book;
import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.UserService;
import nhu.novahub.assignment3.service.BookService;
import nhu.novahub.assignment3.service.RoleService;

@Controller
@SessionAttributes("currentSessionUsername")
@RequestMapping("/book")
public class BookController {
	@Autowired
    ServletContext context;
	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	RoleService roleService;
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
	@RequestMapping(value = {"booksList"}, method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model,@ModelAttribute("currentSessionUsername") final String username) {
		if(username != null) {
			int user_id = userService.findByUsername(username).getId();
			String role = roleService.findById(user_id).getRolename();
			List<Book> booksList = bookService.findAll();
			if(role.equals("user")) {
				model.setViewName("booksList");
				model.addObject("booksList", booksList);
				model.addObject("css_del","display:none");
				if(booksList.isEmpty()) {
					model.addObject("css","display:none");
				}
			}else {
				model.addObject("error", "Bạn không có quyền truy cập");
				model.setViewName("errorPage");
			}
			 return model;
		}
		model.addObject("user", new User());
		model.setViewName("redirect:/login");
		return model;
	}
	
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
			@RequestParam MultipartFile fileUpload,
			@ModelAttribute("currentSessionUsername") String username,HttpServletRequest request){
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
			 model.setViewName("bookCreation");
			 return model;
		    }
			if(fileUpload.getSize() >= 3000000) {
				model.addObject("error", "Dung lượng file không quá 3MB");
				model.addObject("book",book);
				model.setViewName("bookCreation");
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
		model.addObject("msg", "Đã thêm thành công");
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
			ModelAndView model,	@RequestParam MultipartFile fileUpload,HttpServletRequest request) {	
		
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
			 model.setViewName("bookEdition");
			 return model;
		    }
			if(fileUpload.getSize() >= 3000000) {
				model.addObject("error", "Dung lượng file không quá 3MB");
				model.addObject("book",book);
				model.setViewName("bookEdition");
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
				book.setPicture(nameFile+typeOfFile);
				System.out.println("Upload file thành công!"+fileDir+File.separator+nameFile+typeOfFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		//
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
		}else {
			redirectAttributes.addFlashAttribute("msg", "Bạn không có quyền xóa");
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
	
	@RequestMapping(value="uploadPage", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView model = new ModelAndView();
		model.setViewName("uploadPage");
		return model;
	}
	
	@RequestMapping(value="upload", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam(value="fileUpload") CommonsMultipartFile commonsMultipartFiles,HttpServletRequest request,ModelAndView model){
		String nameFile = commonsMultipartFiles.getOriginalFilename();
		String dirFile = request.getSession().getServletContext().getRealPath("/")+"resources/images";
		File fileDir = new File(dirFile);
		System.out.println(commonsMultipartFiles.getSize());
		if(!"".equals(nameFile)){
			if(!(commonsMultipartFiles.getContentType().toLowerCase().equals("image/jpg") 
		            || commonsMultipartFiles.getContentType().toLowerCase().equals("image/jpeg") 
		            || commonsMultipartFiles.getContentType().toLowerCase().equals("image/png"))){
			 model.addObject("error", "chỉ up loại file ảnh");
			 model.setViewName("uploadPage");
			 return model;
		       }
			if(commonsMultipartFiles.getSize() >= 3000000) {
				model.addObject("error", "file vượt quá dung lượng");
				model.setViewName("uploadPage");
				return model;
			}
			 
			if(!fileDir.exists()){
				fileDir.mkdir();
			}
			String typeOfFile = nameFile.substring(nameFile.lastIndexOf("."));
			Date timeUpdate=new Date(System.currentTimeMillis()); 
			SimpleDateFormat timeFormat2 = new SimpleDateFormat("HHmmssddMMyyyy");
			nameFile = timeFormat2.format(timeUpdate.getTime());
			File fileDel = new File(context.getContextPath()+"/resources/images"+File.separator+"22020714032018.jpg");
			if(fileDel.delete()){
    			System.out.println(fileDel.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
			try {
				commonsMultipartFiles.transferTo(new File(fileDir+File.separator+nameFile+typeOfFile));
				System.out.println("Upload file thành công!"+fileDir+File.separator+nameFile+typeOfFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
			model.addObject("urlImage", nameFile+typeOfFile);
		}
		model.setViewName("uploadPage");
		return model;
	}
}
