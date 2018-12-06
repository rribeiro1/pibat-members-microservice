package members.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import members.domain.Situation;
import members.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
public class MemberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService service;

    @InjectMocks
    private MemberController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName() throws Exception {

        String name = "Rafael";
        Situation situation = Situation.Inativo;

        mockMvc.perform(get("/members?name=", name))
            .andExpect(status().isOk())
            .andReturn();
    }
}

