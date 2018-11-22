package members.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import members.model.Member;
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

import java.util.ArrayList;
import java.util.List;

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
    public void testFindAllMembers() throws Exception {

        List<Member> member = new ArrayList<>();

        member.add(Member.builder()
                .id(Integer.valueOf(1))
                .name("Rafael")
                .build());

        when(service.findAll()).thenReturn(member);

        mockMvc.perform(get("/membros", member))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    public void testSaveMember() throws Exception {

        Member member = Member.builder().id(Integer.valueOf(2)).name("Thales").build();

        when(service.save(member)).thenReturn(member);

        mockMvc.perform(post("/membros"))
                .andExpect(status().isOk())
                .andReturn();
    }
}

