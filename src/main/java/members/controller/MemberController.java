package members.controller;

import members.model.Member;
import members.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membros")
public class MemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody public List<Member> getAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseBody public Member save(@RequestBody Member member) {
        return service.save(member);
    }

    private void trace(List<Member> members) {
        LOGGER.debug("Consulta realizada com sucesso para {} membros", members.size());
    }

    private void success() {
        LOGGER.debug("Consulta realizada com sucesso");
    }

}
