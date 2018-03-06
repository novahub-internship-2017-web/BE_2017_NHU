package nhu.novahub.assignment3.logger;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import nhu.novahub.assignment3.entities.User;



@SessionAttributes("currentSessionUsername")
@Aspect
public class LoggerAspectJ {
	@Autowired
	HttpSession session;

  @Before("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
  public ModelAndView logBefore() {
	  ModelAndView model = new ModelAndView();
	  if(session.getAttribute("currentSessionUsername") == null) {
			 model.addObject("user", new User());
			 model.setViewName("loginPage");
			 System.out.println(11111111);
			 return model;
		}
	  else {
		  model.addObject("error", "Bạn không có quyền truy cập");
		  model.setViewName("errorPage");
	  }
	  return model;
  }
}