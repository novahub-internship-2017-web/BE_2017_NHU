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
  @RequestMapping(value= {"/","/booksList","/bookDetail/{id}","booksListByUser"})
  public String welcome() {
    return "home";
  }
  @RequestMapping(value= {"/bookDetailPage"})
  public String bookDetailPage() {
    return "bookDetailPage";
  }
  
  @RequestMapping(value= {"/booksListPage"})
  public String booksListPage() {
    return "booksListPage";
  }
  
  @RequestMapping(value= {"/bookCreationPage"})
  public String bookCreationPage() {
    return "bookCreationPage";
  }
  
  @RequestMapping(value= {"/booksListPageOfUser"})
  public String booksListPageOfUser() {
    return "booksListPageOfUser";
  }
  
  @RequestMapping(value= {"/login"})
  public String login(Authentication authentication) {
	  //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if(authentication!= null) {
	    /*if(auth.toString().contains("ROLE_ADMIN")) {
	      return "home";
	    }else*/
	      return "redirect:booksList";
	  }
	  else return "login";
  }
  @RequestMapping(value= {"/userProfilePage"})
  public String userProfilePage() {
    return "userProfilePage";
  }
	
  @RequestMapping(value= {"/searchBookResult"})
  public String searchBookResult() {
	return "searchBookResult";
  }
  
  @RequestMapping(value= {"/usersListPage"})
  public String usersListPage() {
    return "usersListPage";
  }
	
  @RequestMapping("/403")
  public String error() {
    return "403";
  }
	
  @RequestMapping("/formBook")
  public String formBook() {
    return "formBook";
  }
  
  @RequestMapping("/test")
  public String test() {
    return "test";
  }
}
