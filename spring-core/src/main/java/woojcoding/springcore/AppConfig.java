package woojcoding.springcore;

import woojcoding.springcore.discount.FixDiscountPolicy;
import woojcoding.springcore.member.MemberService;
import woojcoding.springcore.member.MemberServiceImpl;
import woojcoding.springcore.member.MemoryMemberRepository;
import woojcoding.springcore.order.OrderService;
import woojcoding.springcore.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
