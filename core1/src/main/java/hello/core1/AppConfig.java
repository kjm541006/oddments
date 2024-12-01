package hello.core1;

import hello.core1.discount.DiscountPolicy;
import hello.core1.discount.FixDiscountPolicy;
import hello.core1.member.MemberRepository;
import hello.core1.member.MemberService;
import hello.core1.member.MemberServiceImpl;
import hello.core1.member.MemoryMemberRepository;
import hello.core1.order.OrderService;
import hello.core1.order.OrderServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberService(), discountPolicy());
    }
}
