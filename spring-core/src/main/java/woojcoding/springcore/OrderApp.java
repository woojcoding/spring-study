package woojcoding.springcore;

import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberService;
import woojcoding.springcore.order.Order;
import woojcoding.springcore.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
