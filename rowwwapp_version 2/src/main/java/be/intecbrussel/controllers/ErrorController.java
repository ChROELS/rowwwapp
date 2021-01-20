package be.intecbrussel.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/rowwwapp/errors")
    public ModelAndView displayErrorPage(HttpRequest httpRequest){
        ModelAndView errorPage = new ModelAndView("errorPage");
        String errorMsg;
        return errorPage;
    }
}
