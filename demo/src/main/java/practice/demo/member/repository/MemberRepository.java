package practice.demo.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.demo.member.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
