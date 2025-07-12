package hpbao.domain.member;

import hpbao.web.repository.MemberRepository0;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@Repository
@Transactional
public class JpaMemberRepository implements MemberRepository0 {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public void update(Long memberId, Member updateParam) {
        Member findMember = em.find(Member.class, memberId);
        findMember.setPassword(updateParam.getPassword());
        findMember.setUserEmail(updateParam.getUserEmail());
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getUserId().equals(loginId))
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        String jpql = "select m from Member m";
        TypedQuery<Member> query = em.createQuery(jpql, Member.class);
        return query.getResultList();
    }
}
