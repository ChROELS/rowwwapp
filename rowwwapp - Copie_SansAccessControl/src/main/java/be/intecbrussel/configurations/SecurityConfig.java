package be.intecbrussel.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/css/**","/js/**","/image/**").permitAll().and()
                //This first part tells that the paths above should not be secured
                .authorizeRequests().antMatchers("/rowwwapp/bienvenue","/console/**")
                .permitAll().anyRequest().authenticated()
                .and()
                //anyRequest authenticated => once logged in, there is a redirect to the previously requested
                //page that required authentication
                .formLogin().loginPage("/rowwwapp/login").permitAll()
                .failureUrl("/rowwwapp/login-error").
                and().
                logout().permitAll().logoutSuccessUrl("/");
                //login Page => anyone is allowed to view it
        http.csrf().disable();
        //Disables CSRF protection
        http.headers().frameOptions().disable();
        //Disables X-Frame-Options in Spring Security (Line 13) for access to H2 database console.
        // By default, Spring Security will protect against CRSF attacks.
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        //User.withDefaultPasswordEncoder() is considered unsafe for production and is only intended for sample applications
        UserDetails user = User.withDefaultPasswordEncoder().username("username").password("password").
                roles("USER").build();
        return new InMemoryUserDetailsManager(user);
        //In memory user store with a single user

    }
}
