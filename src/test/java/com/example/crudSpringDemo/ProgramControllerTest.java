package com.example.crudSpringDemo;

import com.example.crudSpringDemo.domain.Program;
import com.example.crudSpringDemo.repositories.ProgramRepository;
import com.example.crudSpringDemo.web.ProgramController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebMvcTest(value = ProgramController.class)
public class ProgramControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProgramRepository programRepository;

    Program mockProgram =
            new Program("Title1", "Creator1", "1984", "drama");

    String exampleProgramJsonInput = "{\n" +
            "    \"title\": \"Test\",\n" +
            "    \"creator\": Creator1,\n" +
            "    \"releaseYear\": 1984,\n" +
            "    \"genres\": drama\n" +
            "}";


    @Test
    public void shouldRetrieveProgramWhenGetRouteCalled() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/programs/0").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
//        String expected =
//
//        JSONAssert.assertEquals(expected, result.);
    }
}
