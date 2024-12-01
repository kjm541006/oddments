package hello.core1.member;

import hello.core1.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberservice = appConfig.memberService();
        Long id = 1L;
        Member member = new Member(id, "user1", Grade.VIP);

        memberservice.join(member);
        System.out.println("member = " + member.getUsername());
        System.out.println("member.getId() = " + member.getId());



    }
}
