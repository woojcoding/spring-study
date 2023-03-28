package woojcoding.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.discount.RateDiscountPolicy;
import woojcoding.springcore.member.MemberRepository;
import woojcoding.springcore.member.MemberService;
import woojcoding.springcore.member.MemberServiceImpl;
import woojcoding.springcore.member.MemoryMemberRepository;
import woojcoding.springcore.order.OrderService;
import woojcoding.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
