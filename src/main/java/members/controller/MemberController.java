package members.controller;

import members.model.Member;
import members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membros")
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody public Iterable<Member> getAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseBody public Member save(@RequestBody Member member) {
        return service.save(member);
    }

}
