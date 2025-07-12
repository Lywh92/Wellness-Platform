package hpbao.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("김길동", "abcde123", "abcde123!", "asdfg123@naver.com");

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("김철수", "abcd1234", "abcd1234!", "abcd1234@naver.com");
        Member member2 = new Member("김아리", "dcba1234", "dcba1234!", "dcba1234@naver.com");

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

    @Test
    void updateMember() {
        //given
        Member member = new Member("김철수", "abcd1234", "abcd1234!", "abcd1234@naver.com");
        Member savedMember = memberRepository.save(member);
        Long memberId = savedMember.getId();

        //when
        Member updateParam = new Member("이철수", "abcd2468", "abcd2468!", "abcd2468@naver.com");
        memberRepository.update(memberId, updateParam);

        Member findMember = memberRepository.findById(memberId);

        //then
        assertThat(findMember.getUserName()).isEqualTo(updateParam.getUserName());
        assertThat(findMember.getPassword()).isEqualTo(updateParam.getPassword());
        assertThat(findMember.getUserEmail()).isEqualTo(updateParam.getUserEmail());
    }


}