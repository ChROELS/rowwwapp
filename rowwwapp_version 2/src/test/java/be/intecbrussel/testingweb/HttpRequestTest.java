package be.intecbrussel.testingweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

//RANDOM_PORT => useful to avoid conflicts in test environments
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    //injection of the selected port
    @LocalServerPort
    private int port;

    //Automatically provided
    private TestRestTemplate restTemplate;

    @Autowired
    public HttpRequestTest(TestRestTemplate testRestTemplate){
        this.restTemplate = testRestTemplate;
    }

    @Test
    public void homeShouldReturnAGreeting(){
        //I check if the request let me see the page I am suppose to see by checking
        //if it contains the word 'Bienvenue' (among others) as expected
        assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/",String.class))
                .contains("Bienvenue");
    }
}
