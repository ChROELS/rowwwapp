package be.intecbrussel.testingweb;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
//Automatic injection
@AutoConfigureMockMvc
public class TestRequestTransferredToController {
    //We use a mockMvc to not start the server at all but to test only the layer below that,
    // where Spring handles the incoming HTTP request and hands it off to your controller
    @Autowired
    private MockMvc mockMvc;

   //To avoid org.junit.runners.model.InvalidTestClassError


    @Test
    public void homeShouldReturnAGreeting() throws Exception{
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Bienvenue")));
    }
}
