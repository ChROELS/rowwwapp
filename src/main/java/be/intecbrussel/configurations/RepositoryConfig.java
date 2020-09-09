package be.intecbrussel.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//Automatically creates the beans for h2 Database, Hibernate Entity Manager, JPA Transaction Manager usefull for testing
@EnableAutoConfiguration
@EntityScan(basePackages = {"be.intecbrussel.models"})
//auto-configuration of Spring Data JPA
@EnableJpaRepositories(basePackages ={"be.intecbrussel.repositories"})
//Spring’s annotation-driven transaction management
@EnableTransactionManagement
public class RepositoryConfig {

}
