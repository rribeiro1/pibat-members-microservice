package members.service;

import members.domain.Member;
import members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemberService {

    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * Verify and return the Member given a Name.
     *
     * @param name
     * @return the found Member
     * @throws NoSuchElementException if no Member found.
     */
    public Member findByName(String name) throws NoSuchElementException {
        return repository.findByName(name).orElseThrow(() ->
                new NoSuchElementException("Member does not exist " + name)
        );
    }
}
