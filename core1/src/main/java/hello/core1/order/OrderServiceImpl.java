package hello.core1.order;

import hello.core1.discount.DiscountPolicy;
import hello.core1.member.Member;
import hello.core1.member.MemberService;

public class OrderServiceImpl implements OrderService{

    private final MemberService memberService;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberService memberService, DiscountPolicy discountPolicy) {
        this.memberService = memberService;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {

        Member member = memberService.findById(id);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(id, itemName, itemPrice, discountPrice);

    }
}
