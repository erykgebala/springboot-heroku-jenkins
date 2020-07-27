package pl.eryk.springbootherokujenkins;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(controllers  = HelloController.class)
class SpringbootHerokuJenkinsApplicationTests {

    private HelloController helloController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        this.helloController = new HelloController();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")) .andExpect(status().isOk())
                .andReturn();

        assertEquals( mvcResult.getResponse().getContentAsString(), "hello world");
    }

}
