package hello.core2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    private final MemberService memberService;

    @Autowired
    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void joinTest(){
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        Assertions.assertThat(findMember).isEqualTo(member);

    }

}