package be.intecbrussel.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("rowwwapp/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**","/static/**","/static/js/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        ;
    }
}
