package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final MemberService memberService;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
        System.out.println("memberService = " + memberService);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int price) {
        Member member = memberService.findMember(id);
        int discountPrice = discountPolicy.discount(member, price);

        return new Order(id, itemName, price, discountPrice);

    }
}
