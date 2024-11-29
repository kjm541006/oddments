package com.example.demo.order;

import com.example.demo.member.Member;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
