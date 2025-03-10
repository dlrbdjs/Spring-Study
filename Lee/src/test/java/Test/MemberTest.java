package Test;

import com.example.Lee.SpringConfig;
import com.example.Lee.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.example.Lee.repository.JdbcTemplateMemberRepository;
import com.example.Lee.repository.MemberRepository;

import javax.sql.DataSource;

public class MemberTest {

    @Test
    void saveTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        Member member = new Member();
        member.setId(1L);
        member.setName("Lee");

        memberRepository.save(member);


    }

    @Configuration
    static class TestSpringConfig {
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/dbpractice");
            dataSource.setUsername("root");
            dataSource.setPassword("1234");
            return dataSource;
        }

        @Bean
        public MemberRepository memberRepository() {
            return new JdbcTemplateMemberRepository(dataSource());
        }
    }

}
