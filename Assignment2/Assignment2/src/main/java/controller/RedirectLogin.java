package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@RequestMapping(value = "/LoginPage")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.print("here");
	  request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
