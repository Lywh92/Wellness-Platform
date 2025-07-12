package hpbao.config;

import hpbao.domain.member.JpaMemberRepository;
import hpbao.web.repository.MemberRepository0;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    private final EntityManager em;

    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository0  memberRepository0() {

        return new JpaMemberRepository(em);
    }

}
