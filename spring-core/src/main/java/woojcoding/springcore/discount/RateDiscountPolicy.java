package woojcoding.springcore.discount;

import org.springframework.stereotype.Component;
import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
