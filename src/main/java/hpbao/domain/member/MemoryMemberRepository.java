package hpbao.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemoryMemberRepository {

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getUserId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {return new ArrayList<>(store.values());}

    public void update(Long memberId, Member updateParam) {
        Member findMember = findById(memberId);
        findMember.setUserName(updateParam.getUserName());
        findMember.setPassword(updateParam.getPassword());
        findMember.setUserEmail(updateParam.getUserEmail());
    }

    public void clearStore() {
        store.clear();
    }
}
