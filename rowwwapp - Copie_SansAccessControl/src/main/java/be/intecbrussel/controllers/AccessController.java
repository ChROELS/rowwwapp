package be.intecbrussel.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AccessController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/rowwwapp/login").setViewName("rowwwapp_form");
        registry.addViewController("/rowwwapp/logout").setViewName("home");
        registry.addViewController("/rowwwapp").setViewName("rowwwapp_index_page");
        registry.addViewController("/rowwwapp/bienvenue").setViewName("rowwwapp_index_page");
    }
    @RequestMapping("/rowwwapp/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "rowwwapp_form";
    }
    @RequestMapping("/rowwwapp/logout")
    public String logoutMessage(Model model) {
        model.addAttribute("logoutValue", true);
        return "home";
    }

}
