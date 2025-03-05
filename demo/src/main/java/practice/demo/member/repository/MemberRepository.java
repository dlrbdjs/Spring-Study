package practice.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.demo.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> { // <어떤 엔티티 클래스, PK 타입>
    // 이메일로 회원 정보 조회 (select * from member_table where member_email = ?)
    Optional<MemberEntity> findByMemberEmail(String email);
}
