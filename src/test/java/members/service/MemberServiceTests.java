package members.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import members.model.Member;
import members.repository.MemberRepository;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MemberServiceTests {

    @Mock
    private MemberRepository repository;

    @InjectMocks
    private MemberService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllMembers() {

        List<Member> members = new ArrayList<>();
        members.add(Member.builder().name("rafael").id(Integer.valueOf(1)).build());

        when(repository.findAll()).thenReturn(members);

        Iterable<Member> membersService = service.findAll();

        assertNotNull(membersService);
    }

    @Test
    public void testSaveMember() {

        Member member = Member.builder().id(Integer.valueOf(1)).name("Rafael").build();

        when(repository.save(member)).thenReturn(member);

        Member save = service.save(member);

        assertEquals("Rafael", save.getName());
    }
}
