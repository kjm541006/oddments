package hello.core1.order;

import hello.core1.AppConfig;
import hello.core1.member.Grade;
import hello.core1.member.Member;
import hello.core1.member.MemberService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long id = 1L;
        Member member = new Member(id, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(id, "itemA", 10000);

        System.out.println("order = " + order.toString());
    }
}
