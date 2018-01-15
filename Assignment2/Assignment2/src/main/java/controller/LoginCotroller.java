package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.StaffDAO;
import dao.TeacherDAO;
import dao.UserDAO;
import entities.User;

@Controller
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginCotroller extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    String username = request.getParameter("username");
    String password = request.getParameter("pwd");
    String errorMsg = null;
    User user = null;
    if(username == null || username.equals("")){
      errorMsg ="Username không được để trống";
    }
    if(password == null || password.equals("")){
      errorMsg = "Password không được để trống";
    }
    if(errorMsg != null) {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
      PrintWriter out= response.getWriter();
      response.setContentType("text/html;charset=UTF-8");
      out.println("<font color=red>"+errorMsg+"</font>");
      rd.include(request, response);
    }else{
      user = UserDAO.isValid(username, password);
      if(user != null && user.getActive()==1){
        HttpSession session = request.getSession(true); 
        session.setAttribute("currentSessionUser",user.getUsername()); 
        Cookie userName = new Cookie("currentSessionUser", user.getUsername());
        response.addCookie(userName);
        if(user.getRole().equals("admin")) {
          request.getRequestDispatcher("/WEB-INF/views/admin/indexAdmin.jsp").forward(request, response);
        }else {
          if(StaffDAO.isValid(user.getUserId())) {
            request.setAttribute("user",user);
            request.setAttribute("staff", StaffDAO.getStaff(user.getUserId()));
            request.getRequestDispatcher("/WEB-INF/views/user/indexUserStaff.jsp").forward(request, response);
          }else {
            request.setAttribute("user",user);
            request.setAttribute("teacher", TeacherDAO.getTeacher(user.getUserId()));
            request.getRequestDispatcher("/WEB-INF/views/user/indexUserTeacher.jsp").forward(request, response);
          }
        }
      }else{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        errorMsg = "Tài khoản không tồn tại";
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
        PrintWriter out= response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<font color=red>"+errorMsg+"</font>");
        rd.include(request, response);
        }
    }
  }
  
  
}
