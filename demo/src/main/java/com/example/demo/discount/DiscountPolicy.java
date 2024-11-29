package com.example.demo.discount;

import com.example.demo.member.Member;

public interface DiscountPolicy {
    int discountPrice(Member member, int price);
}
