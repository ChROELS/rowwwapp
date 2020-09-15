package be.intecbrussel.viewResolvers;

import be.intecbrussel.views.ExcelViewCompetition;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class ExcelViewResolverCompetition implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return new ExcelViewCompetition();
    }
}