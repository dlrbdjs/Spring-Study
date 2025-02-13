import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.JdbcTemplateMemberRepository;
import repository.MemberRepository;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
