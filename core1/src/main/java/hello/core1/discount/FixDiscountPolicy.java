package hello.core1.discount;

import hello.core1.member.Grade;
import hello.core1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    int fixDiscountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return fixDiscountPrice;
        }else{
            return 0;
        }
    }
}
