package woojcoding.springcore.discount;

import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}
