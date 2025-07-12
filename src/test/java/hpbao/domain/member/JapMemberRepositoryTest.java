package hpbao.domain.member;

import hpbao.domain.login.LoginService;
import hpbao.web.repository.MemberRepository0;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class JapMemberRepositoryTest {

    @Autowired
    MemberRepository0 memberRepository0;

    @AfterEach
    void afterEach() {
        if (memberRepository0 instanceof MemoryMemberRepository) {
            ((MemoryMemberRepository) memberRepository0).clearStore();
        }
    }

    @Test
    void save() {
        //given
        Member member = new Member("김철수","abcde123","Dkdk!123","yaksa2024@naver.com");

        //when
         memberRepository0.save(member);

        //then
        boolean saveMember = memberRepository0.findById(member.getId()).isPresent();
        Assertions.assertThat(saveMember).isEqualTo(true);

    }

    @Test
    void update() {
        //given
        Member member = new Member("김철수","abcde123","Dkdk!123","yaksa2024@naver.com");
        Member saveMember = memberRepository0.save(member);
        Long memberId = saveMember.getId();

        //when
        Member updateParam = new Member("김철수","abcde123","Dkdl!123","yaksa2025@naver.com");
        memberRepository0.update(memberId, updateParam);

        Optional<Member> findMember = memberRepository0.findById(memberId);
        Assertions.assertThat(findMember.isPresent()).isTrue();

        //then
        Assertions.assertThat(findMember.get().getPassword()).isEqualTo(updateParam.getPassword());
        Assertions.assertThat(findMember.get().getUserEmail()).isEqualTo(updateParam.getUserEmail());

    }



    @Test
    void findById() {
     //given
        Member member = new Member("아아","ababab123","Abab!123","abab2024@naver.com");
        memberRepository0.save(member);

    //when
        Optional<Member> findMember = memberRepository0.findById(member.getId());

        //then
        Assertions.assertThat(findMember.isPresent()).isEqualTo(true);

    }

    @Test
    void findByLoginId() {
        //given
        Member member = new Member("아아","ababab123","Abab!123","abab2024@naver.com");
        memberRepository0.save(member);

        //when
        Optional<Member> loginId = memberRepository0.findByLoginId("ababab123");


        //then
        Assertions.assertThat(loginId.isPresent()).isTrue();

    }

    @Test
    void login() {
        //given
        Member member = new Member("아아","ababab123","Abab!123","abab2024@naver.com");
        memberRepository0.save(member);
        LoginService loginService = new LoginService(memberRepository0);

        //when
        Member login = loginService.login(member.getUserId(), member.getPassword());

        //then
        Assertions.assertThat(login).isEqualTo(member);

    }



    @Test
    void findAll() {

    }
}