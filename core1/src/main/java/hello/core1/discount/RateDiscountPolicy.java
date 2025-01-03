package hello.core1.discount;

import hello.core1.member.Grade;
import hello.core1.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountRate / 100;
        }else return 0;
    }
}
