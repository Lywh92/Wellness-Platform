package hpbao.web.repository;
import hpbao.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository0 {
    Member save(Member member);

    public void update(Long memberId, Member updateParam);

    Optional<Member> findById(Long id);

    Optional<Member> findByLoginId(String loginId);


    List<Member> findAll();

}
