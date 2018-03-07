package nhu.novahub.assignment3.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nhu.novahub.assignment3.entities.Role;
import nhu.novahub.assignment3.entities.User;
import nhu.novahub.assignment3.service.UserService;
import nhu.novahub.assignment3.service.BookService;
import nhu.novahub.assignment3.service.RoleService;

@Controller
@SessionAttributes("currentSessionUsername")
@RequestMapping("admin/user")
public class AdminUserController {
	
	@Autowired
	HttpSession session;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/list", method = {RequestMethod.GET})
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 return model;
		}
		String username = (String) session.getAttribute("currentSessionUsername");
		User userCurrent = userService.findByUsername(username);
		String role = roleService.findById(userCurrent.getId()).getRolename();
		if(role.contains("admin_default")) {
			model.addObject("usersList", userService.findAll());
			model.setViewName("admin/usersList");
		}else if(role.contains("admin")) {
			model.addObject("usersList", userService.findAllUser());
			model.setViewName("admin/usersList");
		}
		else {
			model.addObject("error", "Bạn không có quyền truy cập");
			model.setViewName("errorPage");
		}
		return model;
	}
	
	@RequestMapping(value="/enabled", method = {RequestMethod.POST})
	public void changeEnabled(@RequestParam int idUser,@RequestParam int enabled,
			final RedirectAttributes redirectAttributes) {
		String usernameCurrent = (String) session.getAttribute("currentSessionUsername");
		String usernameDB = userService.findById(idUser).getUsername();
		if(usernameCurrent.equals(usernameDB)) {
			redirectAttributes.addFlashAttribute("msg", "Không thể xóa chính mình");
		}else {
			
			if(enabled == 1) {
				enabled = 0;
			}else {
				enabled = 1;
			}
			userService.changeEnabled(idUser, enabled);
		}
	}
	
	@RequestMapping(value="/role", method = {RequestMethod.POST})
	public void changeRole(@RequestParam int idUser,@RequestParam String role) {
		roleService.changeRole(idUser, role);
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id,
		final RedirectAttributes redirectAttributes) {
		String usernameCurrent = (String) session.getAttribute("currentSessionUsername");
		String usernameDB = userService.findById(id).getUsername();
		if(usernameCurrent.equals(usernameDB)) {
			redirectAttributes.addFlashAttribute("msg", "Không thể xóa chính mình");
		}else {
			bookService.deleteByUserId(id);
			roleService.delete(id);
			userService.deleteById(id);
			redirectAttributes.addFlashAttribute("msg", "Đã xóa thành công");
		}
		return "redirect:../list";

	}
	
	@RequestMapping(value="/addForm", method = {RequestMethod.GET})
	public ModelAndView addForm() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin/userCreation");
		return model;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ModelAndView changePass(@RequestParam String username, 
			@RequestParam String password, @RequestParam String confirmPassword,
			@RequestParam String role) {
		ModelAndView model = new ModelAndView();
		if(!password.equals(confirmPassword)) {
			model.addObject("msg", "Mật khẩu không khớp");
		}else if(userService.findByUsername(username) != null) {
			model.addObject("msg", "Username đã tồn tại");
			model.addObject("usn", username);
			model.addObject("pw", password);
		}else {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.add(user);
		int userId = userService.findByUsername(username).getId();
		Role userRole = new Role();
		userRole.setRoleId(userId);
		userRole.setRolename(role);
		roleService.add(userRole);
		model.addObject("msg", "Thêm thành công");
		}
		model.setViewName("admin/userCreation");
		return model;
	}
	
	@RequestMapping(value="/changePassForm", method = RequestMethod.GET)
	public ModelAndView changePassForm (ModelAndView model) {
		model.setViewName("admin/changePasswordForm");
		return model;
	}
	
	@RequestMapping(value="/changePass", method = RequestMethod.POST)
	public ModelAndView changePass(ModelAndView model, @RequestParam String oldPassword, 
			@RequestParam String newPassword, @RequestParam String confirmPassword) {
		String username = (String) session.getAttribute("currentSessionUsername");
		int user_id = userService.findByUsername(username).getId();
		User user = userService.findByUsername(username);
		if(user.getPassword().equals(oldPassword) && newPassword.equals(confirmPassword)) {
			userService.changePassword(user_id, newPassword);
			model.addObject("msg", "Cập nhật thành công");
		}else {
			model.addObject("msg", "Lỗi");
		}
		model.setViewName("admin/changePasswordForm");
		return model;
	}
}
