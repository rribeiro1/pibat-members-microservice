package members.service;

import members.model.Member;
import members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MemberService {

    private MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        this.repository.findAll().forEach(members::add);
        return members;
    }

    public Member save(Member member) {
        Objects.requireNonNull(member);
        return repository.save(member);
    }

}
