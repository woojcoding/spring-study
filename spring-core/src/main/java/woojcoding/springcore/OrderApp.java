package woojcoding.springcore;

import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberService;
import woojcoding.springcore.member.MemberServiceImpl;
import woojcoding.springcore.order.Order;
import woojcoding.springcore.order.OrderService;
import woojcoding.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
