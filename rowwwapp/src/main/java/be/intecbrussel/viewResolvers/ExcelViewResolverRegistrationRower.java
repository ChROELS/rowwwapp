package be.intecbrussel.viewResolvers;

import be.intecbrussel.views.ExcelViewRegistration;
import be.intecbrussel.views.ExcelViewRegistrationRower;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class ExcelViewResolverRegistrationRower implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return new ExcelViewRegistrationRower();
    }
}
