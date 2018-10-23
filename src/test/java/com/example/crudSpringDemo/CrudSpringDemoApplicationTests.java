package com.example.crudSpringDemo;

import com.example.crudSpringDemo.web.ProgramController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudSpringDemoApplicationTests {

	@Autowired
    private ProgramController programController;

	@Test
	public void contextLoads() throws Exception {
        assertNotNull(programController);
	}

//	@Test
//    public void apiShouldAddPogram

}
