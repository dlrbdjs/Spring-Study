package practice.demo.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.demo.member.dto.MemberDTO;
import practice.demo.member.entity.MemberEntity;
import practice.demo.member.repository.MemberRepository;

import java.util.Optional;

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

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB 에서 조회를 함
            2. DB 에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다 (해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // Entity 객체는 서비스에서까지만
                // entity -> dto 변환 후 리턴
                return MemberDTO.toMemberDTO(memberEntity);
            } else {
                // 비밀번호 불일치 (로그인 실패)
                return null;
            }
        } else {
            // 조회 결과가 없다 (해당 이메일을 가진 회원이 없다)
            return null;
        }

    }
}
