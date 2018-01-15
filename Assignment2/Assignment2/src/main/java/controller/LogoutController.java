package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@WebServlet("/LogoutServlet")
public class LogoutController  extends HttpServlet {  
  private static final long serialVersionUID = 1L;

  //@RequestMapping("/LogoutServlet")
  /*protected void doGet(HttpServletRequest request, HttpServletResponse response)  
      throws ServletException, IOException {  
      response.setContentType("text/html");  
      HttpSession session = request.getSession();
      session.removeAttribute("currentSessionUser");
      response.sendRedirect("/LoginServlet");
  }*/
  @RequestMapping(value = "/login")
  public String login(HttpServletRequest request, HttpServletResponse response)  
      throws ServletException, IOException {
    System.out.print("here");
    return "redirect:index.jsp";
  }
  
  @RequestMapping(value = "/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response)  
      throws ServletException, IOException {
    response.setContentType("text/html");
    HttpSession session = request.getSession(false);
    if(session != null){
      session.invalidate();
    }/*
    //no encoding because we have invalidated the session
    response.sendRedirect("login.html");
    HttpSession session = request.getSession();
    session.removeAttribute("currentSessionUser");*/
    return "index.jsp";
  }
  
  
}  
