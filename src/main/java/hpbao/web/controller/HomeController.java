package hpbao.web.controller;

import hpbao.domain.member.Member;
import hpbao.web.SessionConst;
import hpbao.web.controller.login.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    //    @GetMapping("/hpbao")
    public String home() {

        return "index";
    }
    @GetMapping("/hpbao")
    public String homeAndLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false) Member loginMember,@ModelAttribute LoginForm form, Model model){

        // 세션에 회원 데이터가 없으면 index
        if (loginMember == null) {
            return "index";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "indexLogin";
    }

}
