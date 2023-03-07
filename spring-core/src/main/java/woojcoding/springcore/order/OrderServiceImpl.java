package woojcoding.springcore.order;

import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // 인터페이스에만 의존하도록 코드 변경
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;

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
}
