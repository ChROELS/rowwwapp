package be.intecbrussel.viewResolvers;

import be.intecbrussel.views.ExcelViewRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class ExcelViewResolverRegistration implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return new ExcelViewRegistration();
    }
}
