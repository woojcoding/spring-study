package woojcoding.springcore.discount;

import org.springframework.stereotype.Component;
import woojcoding.springcore.annotation.NotMainDiscountPolicy;
import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;

@Component
@NotMainDiscountPolicy
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
