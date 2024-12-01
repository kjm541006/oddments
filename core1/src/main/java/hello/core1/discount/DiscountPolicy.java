package hello.core1.discount;

import hello.core1.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
