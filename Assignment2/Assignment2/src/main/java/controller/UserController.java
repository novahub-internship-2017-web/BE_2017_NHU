package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StaffDAO;
import dao.TeacherDAO;
import dao.UserDAO;
import entities.Staff;
import entities.Teacher;
import entities.User;


@Controller
@RequestMapping(value = "/user")
public class UserController {
  
  @RequestMapping(value = "teacher")
  public void editTeacher(Model model,HttpServletRequest request,  
      HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    int check = 0;
    int status = 0;
    int userId = Integer.parseInt(request.getParameter("userId"));
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    int birthYear = Integer.parseInt(request.getParameter("birthYear"));
    String country = request.getParameter("country");
    String faculty = request.getParameter("faculty");
    String degree = request.getParameter("degree");
    int classHours = Integer.parseInt(request.getParameter("classHours"));
    int allowance = Integer.parseInt(request.getParameter("allowance"));
    float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
    Teacher teacher = new Teacher(userId, name, birthYear, country, faculty, degree, classHours, allowance, coefficientSalary);
    
    check = UserDAO.editInfo(userId, username, password);
    status = TeacherDAO.editStaffInfo(teacher);
    if(check !=0 && status !=0) {
      msg = "Chỉnh sửa thành công";
    }else {
      msg="Lỗi! Không chỉnh sửa được";
    }
    teacher = TeacherDAO.getTeacher(userId);
    model.addAttribute("teacher", teacher);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("indexTeacher?id="+teacher.getTeacherId()).forward(request, response);
  }
  
  @RequestMapping(value = "indexTeacher", method= {RequestMethod.GET,RequestMethod.POST})
  public String redirectIndexTeacher(@RequestParam("id") String id,ModelMap model) {
    int userId = Integer.parseInt(id);
    model.addAttribute("user", UserDAO.getUser(userId));
    model.addAttribute("teacher", TeacherDAO.getTeacher(userId));
    return "/WEB-INF/views/user/indexUserTeacher.jsp";
  }
  
  @RequestMapping(value = "staff")
  public void editStaff(Model model,HttpServletRequest request,  
      HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    int check = 0;
    int status = 0;
    int userId = Integer.parseInt(request.getParameter("userId"));
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.print(UserDAO.checkUsername(username));
    String name = request.getParameter("name");
    int birthYear = Integer.parseInt(request.getParameter("birthYear"));
    String country = request.getParameter("country");
    String department = request.getParameter("department");
    String position = request.getParameter("position");
    int workDays = Integer.parseInt(request.getParameter("workDays"));
    int allowance = Integer.parseInt(request.getParameter("allowance"));
    float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
    Staff staff = new Staff(userId, name, birthYear, country, department, position, 
        workDays, allowance, coefficientSalary);
    
    check = UserDAO.editInfo(userId, username, password);
    status = StaffDAO.editStaffInfo(staff);
    if(check !=0 && status !=0) {
      msg = "Chỉnh sửa thành công";
    }else {
      msg="Lỗi! Không chỉnh sửa được";
    }
    staff = StaffDAO.getStaff(userId);
    model.addAttribute("staff", staff);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("indexStaff?id="+staff.getStaffId()).forward(request, response);
    }
  
  @RequestMapping(value = "indexStaff", method= {RequestMethod.GET,RequestMethod.POST})
  public String redirectIndexStaff(@RequestParam("id") String id,ModelMap model) {
    int userId = Integer.parseInt(id);
    model.addAttribute("user", UserDAO.getUser(userId));
    model.addAttribute("staff", StaffDAO.getStaff(userId));
    return "/WEB-INF/views/user/indexUserStaff.jsp";
  }
  @RequestMapping(value = {"changePassForm"}, method= {RequestMethod.GET,RequestMethod.POST})
  public String changePassForm(@RequestParam("id") String id, Model model) {   
    User user = UserDAO.getUser(Integer.parseInt(id));
    model.addAttribute("user", user);
    return "/WEB-INF/views/user/changePasswordForm.jsp";   
  }
  @RequestMapping(value = "changePassword")
  public void changePassword(Model model,HttpServletRequest request,  
      HttpServletResponse response) throws ServletException, IOException{   
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    boolean check = false;
    int userId = Integer.parseInt(request.getParameter("userId"));
    String oldPassword = request.getParameter("oldPassword");
    String newPassword = request.getParameter("newPassword");
    User user = UserDAO.getUser(userId);
    if(user.getPassword().equals(oldPassword)) {
      check = UserDAO.changePassword(userId, newPassword);
    }
    if(check){
        msg= "Chỉnh sửa thành công";
    }else {
        msg= "Lỗi! Không sửa được";
    }
    model.addAttribute("user", user);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("changePassForm?id="+user.getUserId()).forward(request, response);
    }
}
