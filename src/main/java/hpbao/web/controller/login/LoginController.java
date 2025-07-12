package hpbao.web.controller.login;

import hpbao.domain.login.LoginService;
import hpbao.domain.member.Member;
import hpbao.web.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;


@Slf4j
@Controller
//@RequestMapping("/hpbao")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

//    @GetMapping
//    public String loginForm() {
//        return "index";
//    }


    @PostMapping("/hpbao")
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/hpbao") String redirectURL,
                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");

            return "index";
        }

        // 로그인 성공 처리
//        HttpSession session = request.getSession();
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:" + redirectURL;

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/hpbao";
    }
}




