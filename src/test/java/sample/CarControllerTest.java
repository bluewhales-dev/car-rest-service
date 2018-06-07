package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamGetCarShouldReturnDefaultCar() throws Exception {

        this.mockMvc.perform(get("/car")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.carName").value("Car is return, Vitz!"));
    }

    @Test
    public void paramGetCarShouldReturnTailoredCar() throws Exception {

        this.mockMvc.perform(get("/car").param("name", "Leaf"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.carName").value("Car is return, Leaf!"));
    }

    @Test
    public void noParamPostCarShouldReturnDefaultCar() throws Exception {

        this.mockMvc.perform(post("/car").param("name", "Leaf"))
                .andDo(print()).andExpect(status().is4xxClientError());

    }

    @Test
    public void ParamPostCarShouldReturnDefaultCar() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("name", "Leaf");
        multiValueMap.add("color", "Red");
        multiValueMap.add("engineSize", "1000");
        this.mockMvc.perform(post("/car").params(multiValueMap))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.carName").value("New Car added, Leaf!"))
                .andExpect(jsonPath("$.carColor").value("Red"))
                .andExpect(jsonPath("$.carEngineSize").value(1000));

    }
}