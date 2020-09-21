package be.intecbrussel.viewResolvers;


import be.intecbrussel.views.ExcelViewRegistrationRower;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
@Component
public class ExcelViewResolverRegistrationRower implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) {
        return new ExcelViewRegistrationRower();
    }
}
