package nhu.novahub.assignment3.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nhu.novahub.assignment3.entities.Book;
import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.BookService;
import nhu.novahub.assignment3.service.RoleService;
import nhu.novahub.assignment3.service.UserService;

/**
 * Handles requests for the application home page.
 */

@SessionAttributes("currentSessionUsername")
@Controller
public class HomeController {
	
	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = {"/","book/booksList"}, method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model,@ModelAttribute("currentSessionUsername") final String username) {
		if(username != null) {
			int user_id = userService.findByUsername(username).getId();
			String role = roleService.findById(user_id).getRolename();
			List<Book> booksList = bookService.findAll();
			if(booksList.isEmpty()) {
				model.addObject("css","display:none");
			}
			model.addObject("booksList", booksList);
			if(role.contains("admin")) {
				model.setViewName("admin/booksList");
			}
			if(role.equals("user")) {
				model.setViewName("booksList");
			}
			 return model;
		}
		model.addObject("user", new User());
		model.setViewName("redirect:/login");
		return model;
	}
	
	@RequestMapping(value = "/404")
	public ModelAndView accessDenied(ModelAndView model) {
		model.addObject("error", "Lỗi 404");
	model.setViewName("errorPage");
	return model;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String doGetLogin(Model model) {
	    if (!model.containsAttribute("user")) {
	        model.addAttribute("user", new User());
	      }
	    return "loginPage";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	 public String doPostLogin(@ModelAttribute("user") @Valid User user,BindingResult result,
			 Model model,final RedirectAttributes rd) {
		 if(result.hasErrors()) {
			 return "loginPage";
		 }
		 User userCurrent = userService.checkExist(user);
		 if(userCurrent==null) {
			 model.addAttribute("msg", "Username hoặc password không đúng. ");
			 return "loginPage";
		 }else {				
			 rd.addFlashAttribute("currentSessionUsername",userCurrent.getUsername());
			 return "redirect:book/booksList";
		 }
	 }
}
	