package practice.demo.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.demo.member.dto.MemberDTO;
import practice.demo.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
    }
}
