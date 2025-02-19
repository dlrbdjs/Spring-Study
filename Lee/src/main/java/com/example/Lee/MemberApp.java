package com.example.Lee;

import com.example.Lee.domain.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.Lee.repository.MemberRepository;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        Member member = new Member();
        member.setId(1L);
        member.setName("Lee");

//        memberRepository.save(member);
        System.out.println("다 출력하기");
        memberRepository.findAll().forEach(System.out::println);
        System.out.println("1번만 출력하기");
        memberRepository.findById(1L).ifPresent(System.out::println);
        System.out.println("Lee 출력하기");
        memberRepository.findByName("Lee").ifPresent(System.out::println);

    }
}
