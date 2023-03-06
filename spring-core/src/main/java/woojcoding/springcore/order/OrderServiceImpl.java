package woojcoding.springcore.order;

import woojcoding.springcore.discount.DiscountPolicy;
import woojcoding.springcore.discount.FixDiscountPolicy;
import woojcoding.springcore.discount.RateDiscountPolicy;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberRepository;
import woojcoding.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 인터페이스에만 의존하도록 코드 변경
    private DiscountPolicy discountPolicy;

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // DIP 위반으로 인해 코드 변경이 불가피 하게 되고 따라서 OCP도 위반하게 된다.
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
