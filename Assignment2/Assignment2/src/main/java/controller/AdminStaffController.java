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


import dao.StaffDAO;
import dao.UserDAO;
import entities.Staff;

@Controller
@RequestMapping("/admin/staff")
public class AdminStaffController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  /*public String test() {
    return "redirect:www.google.com.vn";
  }*/
  
  
  @RequestMapping(value= {"","/listStaff"})
  public String getAllList(Model model) {
    List<Staff> listStaff = new ArrayList<Staff>();
    listStaff = StaffDAO.getAll();
    model.addAttribute("listStaff", listStaff);    
    return "/WEB-INF/views/admin/ListStaff.jsp";   
  }
  @RequestMapping("addForm")
  public String addForm() {   
    return "/WEB-INF/views/admin/FormAddStaff.jsp";   
  }
  @RequestMapping("add")
  public void addForm(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{   
    String msg = null;
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");
    // add new user
    if(UserDAO.checkUsername(username)) {
      msg= "Username đã tồn tại";
      request.setAttribute("message", msg);
      request.getRequestDispatcher("addForm").forward(request, response);
    }else {
      UserDAO.add(username, password, role);
       // get id of new user
      int staffId = UserDAO.getId(username);
      String name = request.getParameter("name");
      int birthYear = Integer.parseInt(request.getParameter("birthYear"));
      String country = request.getParameter("country");
      String department = request.getParameter("department");
      String position = request.getParameter("position");
      int workDays = Integer.parseInt(request.getParameter("workDays"));
      int allowance = Integer.parseInt(request.getParameter("allowance"));
      float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
      Staff staff = new Staff(staffId, name, birthYear, country, department, position, 
          workDays, allowance, coefficientSalary);
      int status = StaffDAO.add(staff);
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
    Staff staff = StaffDAO.getStaff(Integer.parseInt(id));
    if(staff != null) {
      model.addAttribute("staff", staff);
      return "/WEB-INF/views/admin/FormEditStaff.jsp";
    }else {
      model.addAttribute("message","Không có dữ liệu");
      return "/WEB-INF/views/admin/NotificationPage.jsp";
    }
  }
  @RequestMapping(value = "edit")
  public void edit(Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{   
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String msg = null;
    int staffId = Integer.parseInt(request.getParameter("staffId"));
    String name = request.getParameter("name");
    int birthYear = Integer.parseInt(request.getParameter("birthYear"));
    String country = request.getParameter("country");
    String department = request.getParameter("department");
    String position = request.getParameter("position");
    int workDays = Integer.parseInt(request.getParameter("workDays"));
    int allowance = Integer.parseInt(request.getParameter("allowance"));
    float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
    Staff staff = new Staff(staffId, name, birthYear, country, department, position, 
        workDays, allowance, coefficientSalary);
    int status = StaffDAO.editStaffInfo(staff);
    if(status != 0) {
      msg= "Chỉnh sửa thành công";
    }else {
      msg= "Lỗi! Chưa sửa được";
    }
    staff = StaffDAO.getStaff(staffId);
    model.addAttribute("staff", staff);
    request.setAttribute("message", msg);
    request.getRequestDispatcher("editForm?id="+staff.getStaffId()).forward(request, response);
  }
  
  @RequestMapping(value = {"delete"}, method= RequestMethod.GET)
  public void delete(@RequestParam("id") String id, Model model,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
    String msg = null;
    int staffId = Integer.parseInt(id);
    StaffDAO.delete(staffId);
    int status = UserDAO.delete(staffId);
    if(status != 0) {
      msg= "Xoa thanh cong";
    }else {
      msg= "Loi ! Chua xoa duoc";
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out= response.getWriter();
    out.println("<script type=\"text/javascript\">");
    out.println("alert('"+ msg +"');");
    out.println("location='listStaff';");
    out.println("</script>");
  }
}
