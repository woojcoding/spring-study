package woojcoding.springcore;

import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.discount.FixDiscountPolicy;
import woojcoding.springcore.member.MemberRepository;
import woojcoding.springcore.member.MemberService;
import woojcoding.springcore.member.MemberServiceImpl;
import woojcoding.springcore.member.MemoryMemberRepository;
import woojcoding.springcore.order.OrderService;
import woojcoding.springcore.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
