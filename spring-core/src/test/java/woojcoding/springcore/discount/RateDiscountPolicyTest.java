package woojcoding.springcore.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP DISCOUNT = 10 %")
    void vip() throws Exception {
        //given
        Member member = new Member(1L, "vipMember", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Not Vip")
    void notVip() throws Exception {
        //given
        Member member = new Member(2L, "basicMember", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}
