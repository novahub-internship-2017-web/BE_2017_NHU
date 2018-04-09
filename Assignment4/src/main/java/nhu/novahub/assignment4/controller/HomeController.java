package nhu.novahub.assignment4.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  
  @RequestMapping(value= {"/header"})
  public String header() {
    return "html/header";
  }
  @RequestMapping(value= {"/","/booksList","/bookDetail/{id}"})
  public String welcome() {
    return "index";
  }
  @RequestMapping(value= {"/bookDetailPage"})
  public String bookDetailPage() {
    return "bookDetailPage";
  }
  @RequestMapping(value= {"/bookCreationPage"})
  public String bookCreationPage() {
    return "bookCreationPage";
  }
	@RequestMapping(value= {"/login"})
  public String login(Authentication authentication) {
	  //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if(authentication!= null) {
	    /*if(auth.toString().contains("ROLE_ADMIN")) {
	      return "home";
	    }else*/
	      return "home";
	  }
	  else return "login";
  }
	
	@RequestMapping("/403")
  public String error() {
    return "403";
  }
	@RequestMapping("/test")
  public String test() {
    return "test";
  }
	
	/*@RequestMapping(value = "/test1", method = RequestMethod.GET)
  @ResponseBody
  public String currentUserName( Principal principal) {
      return principal.getName();
  }*/
}
