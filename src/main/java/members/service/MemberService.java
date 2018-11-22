package members.service;

import members.model.Member;
import members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MemberService {

    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Iterable<Member> findAll() {
        return repository.findAll();
    }

    public Member save(Member member) {
        Objects.requireNonNull(member);
        return repository.save(member);
    }

}
