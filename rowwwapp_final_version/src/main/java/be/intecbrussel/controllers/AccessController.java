package be.intecbrussel.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AccessController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/rowwwapp/login").setViewName("rowwwapp_form");
        registry.addViewController("/rowwwapp/competition/results/logout").setViewName("rowwwapp_form");
        registry.addViewController("/rowwwapp").setViewName("rowwwapp_index_page");
        registry.addViewController("/rowwwapp/bienvenue").setViewName("rowwwapp_index_page");
    }

}
