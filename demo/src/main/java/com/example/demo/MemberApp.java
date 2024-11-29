package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member joinMember = new Member(1L, "member1", Grade.VIP);
        memberService.join(joinMember);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + joinMember.getName());
        System.out.println("find Member = " + findMember.getName());
        if(findMember == joinMember) System.out.println("equal");


    }
}
