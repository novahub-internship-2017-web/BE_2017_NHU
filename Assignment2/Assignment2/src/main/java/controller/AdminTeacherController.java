package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.TeacherDAO;
import dao.UserDAO;
import entities.Teacher;



@Controller
@RequestMapping("/admin/teacher")
public class AdminTeacherController extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @RequestMapping(value= {"","/listTeacher"})
  public String getAllList(Model model) {
    List<Teacher> listTeacher = new ArrayList<Teacher>();
    listTeacher = TeacherDAO.getAll();
    model.addAttribute("listTeacher", listTeacher);    
    return "/WEB-INF/views/admin/ListTeacher.jsp";   
  }
  
  @RequestMapping("addForm")
  public String addForm(){   
    
    return "/WEB-INF/views/admin/FormAddTeacher.jsp";   
  }
  
  @RequestMapping("add")
  public void add(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{ 
    response.setContentType("text/html;charset=UTF-8");
    String msg = null;
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");
    if(UserDAO.checkUsername(username)){
      msg= "Username đã tồn tại";
      request.setAttribute("message", msg);
      request.getRequestDispatcher("addForm").forward(request, response);
    }else {
      UserDAO.add(username, password, role);
      int teacherId = UserDAO.getId(username);
      String name = request.getParameter("name");
      int birthYear = Integer.parseInt(request.getParameter("birthYear"));
      String country = request.getParameter("country");
      String faculty = request.getParameter("faculty");
      String degree = request.getParameter("degree");
      int classHours = Integer.parseInt(request.getParameter("classHours"));
      int allowance = Integer.parseInt(request.getParameter("allowance"));
      float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
      Teacher teacher = new Teacher(teacherId, name, birthYear, country, faculty, degree, classHours, allowance, coefficientSalary);
      int status = TeacherDAO.add(teacher);
      if(status != 0) {
        msg= "Thêm thành công";
      }else {
        msg= "Lỗi ! Chưa thêm được";
      }
      request.setAttribute("message", msg);
      request.getRequestDispatcher("addForm").include(request, response);
    }
  }
  
  @RequestMapping(value = {"editForm","editForm/"}, method= {RequestMethod.GET,RequestMethod.POST})
  public String editForm(@RequestParam("id") String id, Model model) {   
    Teacher teacher = TeacherDAO.getTeacher(Integer.parseInt(id));
    if(teacher != null) {
      model.addAttribute("teacher", teacher);
      return "/WEB-INF/views/admin/FormEditTeacher.jsp";  
    }else {
      model.addAttribute("message", "Không có dữ liệu");
      return "/WEB-INF/views/admin/NotificationPage.jsp";
    }
  }
  
  @RequestMapping(value = "edit")
  public void edit(Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{   
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    int teacherId = Integer.parseInt(request.getParameter("teacherId"));
    String name = request.getParameter("name");
    int birthYear = Integer.parseInt(request.getParameter("birthYear"));
    String country = request.getParameter("country");
    String faculty = request.getParameter("faculty");
    String degree = request.getParameter("degree");
    int classHours = Integer.parseInt(request.getParameter("classHours"));
    int allowance = Integer.parseInt(request.getParameter("allowance"));
    float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
    Teacher teacher = new Teacher(teacherId, name, birthYear, country, faculty, degree, classHours, allowance, coefficientSalary);
    int status = TeacherDAO.editStaffInfo(teacher);
    if(status != 0) {
      msg= "Chỉnh sửa thành công";
    }else {
      msg= "Lỗi! Chưa sửa được";
    }
    teacher = TeacherDAO.getTeacher(teacherId);
    model.addAttribute("teacher", teacher);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("editForm?id="+teacher.getTeacherId()).forward(request, response);
  }
  
  @RequestMapping(value = {"delete"}, method= RequestMethod.GET)
  public void delete(@RequestParam("id") String id, Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
    String msg = null;
    int teacherId = Integer.parseInt(id);
    TeacherDAO.delete(teacherId);
    int status = UserDAO.delete(teacherId);
    if(status != 0) {
      msg= "Xoa thanh cong";
    }else {
      msg= "Loi ! Chua xoa duoc";
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out= response.getWriter();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('"+ msg +"');");
    out.println("location='listTeacher';");
    out.println("</script>");
  }
  
  
}
