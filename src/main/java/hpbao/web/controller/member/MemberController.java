package hpbao.web.controller.member;

import hpbao.domain.member.Member;
import hpbao.domain.member.MemoryMemberRepository;
import hpbao.web.controller.member.form.MemberSaveForm;
import hpbao.web.repository.MemberRepository0;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/hpbao")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository0 memberRepository0;


    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new Member());
        return "members/joinForm";
    }

    @PostMapping("/join")
    public String joinMember(@Validated @ModelAttribute("member")MemberSaveForm form, BindingResult bindingResult) {

        // 아이디,이메일 중복 확인 로직 -> jpa 기능 추가 필요

        //비밀번호, 비밀번호 확인 로직 추가



        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "members/joinForm";
        }

        Member member = new Member(form.getUserName(),form.getUserId(),form.getPassword(), form.getUserEmail());

        Member saveMember = memberRepository0.save(member);
        return "redirect:/hpbao";
    }


}