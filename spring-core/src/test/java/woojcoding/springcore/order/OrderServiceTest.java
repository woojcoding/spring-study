package woojcoding.springcore.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woojcoding.springcore.AppConfig;
import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    MemberService memberService;

    OrderService orderService;

    @BeforeEach
    public void setup() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() throws Exception {
        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
