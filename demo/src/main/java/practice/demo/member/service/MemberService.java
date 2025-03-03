package practice.demo.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.demo.member.dto.MemberDTO;
import practice.demo.member.entity.MemberEntity;
import practice.demo.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2. repository 의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        // repository 의 save 메서드 호출 (조건, entity 객체를 넘겨줘야 함)
    }
}
