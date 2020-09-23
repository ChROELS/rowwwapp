package be.intecbrussel.configurations;

import be.intecbrussel.ViewResolvers.ExcelViewResolverCompetition;
import be.intecbrussel.ViewResolvers.ExcelViewResolverRegistration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ExportConfig extends WebMvcConfigurerAdapter{
        //To be able to export
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.defaultContentType(MediaType.ALL);
        }
        /*
         * Configure ContentNegotiatingViewResolver
         */
        @Bean
        public ViewResolver contentNegotiatingViewResolverCompetition(ContentNegotiationManager manager) {
            ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
            resolver.setContentNegotiationManager(manager);

            // Define all possible view resolvers
            List<ViewResolver> resolvers = new ArrayList<>();

            resolvers.add(excelViewResolverCompetition());
            resolver.setViewResolvers(resolvers);
            return resolver;
        }
    @Bean
    public ViewResolver contentNegotiatingViewResolverRegistration(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(excelViewResolverRegistration());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

        /*
         * Configure View resolver to provide XLS output using Apache POI library to
         * generate XLS output for an object content
         */
        @Bean
        @Order(value=2)
        public ViewResolver excelViewResolverRegistration() {
            return new ExcelViewResolverRegistration();
        }
        @Bean
        @Order(value=1)
        public ViewResolver excelViewResolverCompetition() {
            return new ExcelViewResolverCompetition();
        }



}
