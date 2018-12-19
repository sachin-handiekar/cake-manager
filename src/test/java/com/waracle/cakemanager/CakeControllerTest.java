package com.waracle.cakemanager;

import com.waracle.cakemanager.domain.Cake;
import com.waracle.cakemanager.service.CakeService;
import com.waracle.cakemanager.web.CakeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CakeController.class)
public class CakeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CakeService service;

    @Test
    public void testCakesRoute() throws Exception {

        Cake cake = new Cake();

        cake.setDescription("Dummy description");
        cake.setImage("http://localhost:8080/img.src");
        cake.setTitle("Dummy Title");

        List<Cake> allEmployees = Arrays.asList(cake);

        given(service.getAllCakes()).willReturn(allEmployees);

        mvc.perform(get("/cakes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


}
