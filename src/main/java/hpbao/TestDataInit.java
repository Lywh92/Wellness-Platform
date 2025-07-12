package hpbao;

import hpbao.domain.member.Member;
import hpbao.domain.member.MemoryMemberRepository;
import hpbao.web.repository.MemberRepository0;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository0 memberRepository0;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setUserId("abcde123");
        member.setPassword("Dkdk!123");
        member.setUserName("김테스");

        memberRepository0.save(member);
    }

}
