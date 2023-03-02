package woojcoding.springcore.order;

import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.discount.FixDiscountPolicy;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberRepository;
import woojcoding.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
