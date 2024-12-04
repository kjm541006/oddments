package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.RateDiscountPolicy;
import hello.core2.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Configuration
    public static class testConfig{

        @Bean
        public DiscountPolicy discountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
        }

        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl(memberService(), discountPolicy());
        }
    }

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void beforeEach(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(testConfig.class);
        memberService = ac.getBean(MemberService.class);
        orderService = ac.getBean(OrderService.class);
    }


//    public OrderServiceTest(MemberService memberService, OrderService orderService) {
//        this.memberService = memberService;
//        this.orderService = orderService;
//    }

    @Test
    void createOrder(){
        Long id = 1L;
        Member member = new Member(id, "MemberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(member.getId(), "itemA", 20000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(2000);
    }


}