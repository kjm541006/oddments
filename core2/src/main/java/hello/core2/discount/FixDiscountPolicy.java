package hello.core2.discount;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscount")
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price - discountPrice;
        }else{
            return 0;
        }
    }
}
