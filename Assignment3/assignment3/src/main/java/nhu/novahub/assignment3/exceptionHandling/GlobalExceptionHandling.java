package nhu.novahub.assignment3.exceptionHandling;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandling {
  @ExceptionHandler(Exception.class)
  private ModelAndView processIOException(Exception ex) {
    ModelAndView model = new ModelAndView("errorPage");
    model.addObject("error", ex.getMessage());
    return model;
  }
}

