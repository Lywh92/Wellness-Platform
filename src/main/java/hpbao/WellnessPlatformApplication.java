package hpbao;

import hpbao.config.JpaConfig;
import hpbao.domain.member.Member;
import hpbao.web.repository.MemberRepository0;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(JpaConfig.class)
@SpringBootApplication
public class WellnessPlatformApplication {

	public static void main(String[] args) {SpringApplication.run(WellnessPlatformApplication.class, args);}


}
