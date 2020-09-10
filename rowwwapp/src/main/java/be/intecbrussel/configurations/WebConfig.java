package be.intecbrussel.configurations;

import be.intecbrussel.viewResolvers.CsvViewResolverCompetition;
import be.intecbrussel.viewResolvers.CvsViewResolver;
import be.intecbrussel.viewResolvers.ExcelViewResolver;
import be.intecbrussel.viewResolvers.ExcelViewResolverCompetition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    //To be able to export
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON).favorPathExtension(true);
    }
    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(csvViewResolver());
        resolvers.add(excelViewResolver());
        resolvers.add(excelViewResolverCompetition());
        resolvers.add(csvViewResolverCompetition());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }
    @Bean
    public ViewResolver excelViewResolverCompetition() {
        return new ExcelViewResolverCompetition();
    }

    /*
     * Configure View resolver to provide Csv output using Super Csv library to
     * generate Csv output for an object content
     */
    @Bean
    public ViewResolver csvViewResolver() {
        return new CvsViewResolver();
    }
    @Bean
    public ViewResolver csvViewResolverCompetition() {
        return new CsvViewResolverCompetition();
    }

    /*
     * Configure View resolver to provide Pdf output using iText library to
     * generate pdf output for an object content
     */

}


