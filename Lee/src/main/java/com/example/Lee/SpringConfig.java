package com.example.Lee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.example.Lee.repository.JdbcTemplateMemberRepository;
import com.example.Lee.repository.MemberRepository;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbpractice");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

//    private final DataSource dataSource;
//
//    @Autowired
//    public com.example.Lee.SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource());
    }
}
