package woojcoding.springcore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
    // 인터페이스에만 의존하도록 코드 변경
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
