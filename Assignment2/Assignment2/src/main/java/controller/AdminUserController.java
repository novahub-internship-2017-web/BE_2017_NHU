package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/admin/user")
public class AdminUserController {
  
  @RequestMapping(value= {"","/listUser"})
  public String getAllList(Model model) {
    List<User> listUser = new ArrayList<User>();
    listUser = UserDAO.getAll();
    model.addAttribute("listUser", listUser);    
    return "/WEB-INF/views/admin/ListUser.jsp";   
  }
  
  @RequestMapping(value = "/role",method=RequestMethod.POST)
  public void role(HttpServletRequest request,HttpServletResponse response) {
    int userId = Integer.parseInt(request.getParameter("idUser"));
    int active = Integer.parseInt(request.getParameter("status"));
    UserDAO.changeActive(userId, active); 
  }
  
  @RequestMapping(value = "/checkUsername",method=RequestMethod.POST)
  public boolean checkUsername(HttpServletRequest request,HttpServletResponse response) {
    boolean check = false;
    check = UserDAO.checkUsername(request.getParameter("username"));
    System.out.print(check);
    return check;
  }
  @RequestMapping("addForm")
  public String addForm() {   
    return "/WEB-INF/views/admin/FormAddUser.jsp";   
  }
  
  @RequestMapping(value = {"delete"}, method= RequestMethod.GET)
  public void delete(@RequestParam("id") String id, Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
    String msg = null;
    int userId = Integer.parseInt(id);
    if(StaffDAO.isValid(userId)) {
      StaffDAO.delete(userId);
    }
    if(TeacherDAO.isValid(userId)) {
      TeacherDAO.delete(userId);
    }
    int status = UserDAO.delete(userId);
    if(status != 0) {
      msg= "Xoa thanh cong";
    }else {
      msg= "Loi ! Chua xoa duoc";
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out= response.getWriter();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('"+ msg +"');");
    out.println("location='listUser';");
    out.println("</script>");
  }
  
  @RequestMapping(value = {"editForm"}, method= {RequestMethod.GET,RequestMethod.POST})
  public String editForm(@RequestParam("id") String id, Model model) {   
    User user = UserDAO.getUser(Integer.parseInt(id));
    model.addAttribute("user", user);
    return "/WEB-INF/views/admin/FormEditUser.jsp";   
  }
  
  @RequestMapping(value = "edit")
  public void edit(Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{   
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    int userId = Integer.parseInt(request.getParameter("userId"));
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");
    int active = Integer.parseInt(request.getParameter("active"));
    User user = new User(userId, username, password, role, active);
    int status = UserDAO.editUserInfo(user);
    if(status != 0) {
    msg= "Chỉnh sửa thành công";
    }else {
    msg= "Lỗi ! Không sửa được";
    }
    user = UserDAO.getUser(userId);
    model.addAttribute("user", user);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("editForm?id="+user.getUserId()).forward(request, response);
    
  }
  
  @RequestMapping(value = "search")
  public String search(@RequestParam("keyword") String keyword,@RequestParam("searchBy") String searchBy,ModelMap model,HttpServletRequest request,  
      HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    List<Teacher> listTeacher = new ArrayList<Teacher>();
    List<Staff> listStaff = new ArrayList<Staff>();
    if(searchBy.equals("name")) {
      listTeacher = TeacherDAO.searchBy("Name", keyword);
      listStaff = StaffDAO.searchBy("Name", keyword);
    }else if(searchBy.equals("country")) {
      listTeacher = TeacherDAO.searchBy("Country", keyword);
      listStaff = StaffDAO.searchBy("Country", keyword);
    }else if(searchBy.equals("birthYear")) {
      listTeacher = TeacherDAO.searchBy("BirthYear", keyword);
      listStaff = StaffDAO.searchBy("BirthYear", keyword);
    }/*else {
      msg = "Không tìm thấy kết quả";
    }*/
    if(!listStaff.isEmpty() || !listTeacher.isEmpty()) {
      model.addAttribute("listStaff", listStaff);    
      model.addAttribute("listTeacher", listTeacher); 
      return "/WEB-INF/views/admin/ListSearch.jsp"; 
    }else {
      msg = "Không tìm thấy kết quả";
      model.addAttribute("message", msg); 
      return "/WEB-INF/views/admin/NotificationPage.jsp";  
    }
  }
  
  @RequestMapping(value = {"editInfoDetail"}, method= RequestMethod.GET)
  public String editInfoDetail(@RequestParam("id") String id, Model model) {   
    System.out.println(StaffDAO.isValid(Integer.parseInt(id)));
    if(StaffDAO.isValid(Integer.parseInt(id))) {
      Staff staff = StaffDAO.getStaff(Integer.parseInt(id));
      model.addAttribute("staff", staff);
      return "/WEB-INF/views/admin/FormEditStaff.jsp";     
    }
    else{
      Teacher teacher = TeacherDAO.getTeacher(Integer.parseInt(id));
      model.addAttribute("teacher", teacher);
      return "/WEB-INF/views/admin/FormEditTeacher.jsp";   
    }
  }
  
  @RequestMapping(value = {"changePassForm"}, method= RequestMethod.GET)
  public String changePassForm(@RequestParam("id") String id, Model model) {   
    User user = UserDAO.getUser(Integer.parseInt(id));
    model.addAttribute("user", user);
    return "/WEB-INF/views/admin/changePasswordForm.jsp";   
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
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out= response.getWriter();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('"+ msg +"');");
    out.println("location='editForm?id="+user.getUserId()+"';");
    out.println("</script>");
  }
}
