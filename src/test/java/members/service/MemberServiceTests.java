package members.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import members.domain.Member;
import members.domain.Situation;
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

import java.util.Optional;

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
    public void testFindByName() {

        String name = "Rafael";
        Situation situation = Situation.Ativo;
        Member member = new Member(1, "Rafael", situation);

        when(repository.findByName(name)).thenReturn(Optional.ofNullable(member));

        Member m = service.findByName(name);

        assertNotNull(m);
        assertEquals("Ativo", m.getSituation().getLabel());
        assertEquals("Rafael", m.getName());
    }

}
