package carmanager;


import carmanager.chassis.ChassisService;
import carmanager.entity.Chassis;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ChassisControllerTest {

    @Autowired private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private ChassisService chassisService;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, objectMapper);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createChassisDelegatesToService() throws Exception {

        mockMvc.perform(
                post("/chassis?chassisName=foo&price=1"))
                .andExpect(status().isOk());

        Chassis chassis = chassisService.fetchChassis().get(3);
        Chassis expected = Chassis.builder().id(4L).chassisName("foo").price(1).build();
        assertEquals(expected , chassis);
    }
}
