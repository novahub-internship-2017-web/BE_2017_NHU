package nhu.novahub.assignment3.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.UserService;
import nhu.novahub.assignment3.service.BookService;
import nhu.novahub.assignment3.service.RoleService;

@Controller
@SessionAttributes("currentSessionUsername")
public class UserController {
	@Autowired
	HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private RoleService roleService;
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("user") @Valid User user, BindingResult result,
			 ModelAndView model) {

	  model.addObject("booksList", bookService.findAll());
	  model.setViewName("booksList");

	  return model;

	}
	*/
	
	/*
	@RequestMapping(value="/login", method = {RequestMethod.POST,RequestMethod.GET})
	 public ModelAndView login(@ModelAttribute("user") @Valid User user, BindingResult result,
			 ModelAndView model) {
		 if(result.hasErrors()) {
			 model.setViewName("loginPage");
		 }else {
			 User userCurrent = userService.checkExist(user);
			 if(userCurrent==null) {
				 model.addObject("msg", "Username hoặc password không đúng. ");
				 model.setViewName("loginPage");
			 }else {				
				 int userId = userCurrent.getId();
				 model.addObject("currentSessionUsername",userCurrent.getUsername());
				 model.addObject("userCurrent",userCurrent);
				 model.addObject("booksList", bookService.findAll());
				 if(roleService.findById(userId).getRolename().equals("user")) {
					 model.setViewName("booksList");
				 }else if(roleService.findById(userId).getRolename().equals("admin")) {
					 model.setViewName("admin/booksList");
				 }else {
					 System.out.print("lỗi phân quyền");
				 }
			 }
		 }
		 
		 return model;
	 }*/
	@RequestMapping (value="/logout")
	public ModelAndView logout(ModelAndView model,SessionStatus status) {
		status.setComplete();
		model.addObject("user", new User());
		model.setViewName("loginPage");
		return model;
	}
	@RequestMapping(value="/changePassForm", method = RequestMethod.GET)
	public ModelAndView changePassForm (ModelAndView model) {
		model.setViewName("changePasswordForm");
		return model;
	}
	
	@RequestMapping(value="/changePass", method = RequestMethod.POST)
	public ModelAndView changePass(ModelAndView model, @RequestParam String oldPassword, 
			@RequestParam String newPassword, @RequestParam String confirmPassword) {
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		User user = userService.findByUsername(username);
		String md5_oldPass = org.springframework.util.DigestUtils.md5DigestAsHex(oldPassword.getBytes());
		if(user.getPassword().equals(md5_oldPass) && newPassword.equals(confirmPassword)) {
			String md5_newPass = org.springframework.util.DigestUtils.md5DigestAsHex(newPassword.getBytes());
			userService.changePassword(user_id, md5_newPass);
			model.addObject("msg", "Cập nhật thành công");
		}else {
			model.addObject("msg", "Lỗi");
		}
		model.setViewName("changePasswordForm");
		return model;
	}
	 /*@RequestMapping(value="/login")
	 public ModelAndView login(@RequestParam String username, @RequestParam String password,
			 ModelAndView model) {
		 User user = new User(username, password);
		 User userCurrent = userService.checkExist(user);
		 if(userCurrent==null) {
			 model.setViewName("loginPage");
		 }else {
			 HttpSession session = request.getSession(true); 
			 session.setAttribute("currentSessionUsername",userCurrent.getUsername()); 
			 model.addObject("currentSessionUsername",userCurrent.getUsername());
			 model.addObject("userCurrent",userCurrent);
			 model.addObject("booksList", bookService.findAll());
			 if(userCurrent.getRole().equals("user")) {
				 model.setViewName("booksList");
			 }else if(userCurrent.getRole().equals("admin")) {
				 model.setViewName("admin"); 
			 }else {
				 System.out.print("lỗi phân quyền");
			 }
		 }
		 return model;
	 }*/
}
