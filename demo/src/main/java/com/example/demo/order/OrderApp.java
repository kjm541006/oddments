package com.example.demo.order;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        
        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);
        
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order.toString() = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        
        
    }
}
