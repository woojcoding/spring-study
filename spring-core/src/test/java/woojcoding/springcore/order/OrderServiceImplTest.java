package woojcoding.springcore.order;

import org.junit.jupiter.api.Test;
import woojcoding.springcore.discount.FixDiscountPolicy;
import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository =
                new MemoryMemberRepository();

        memoryMemberRepository.save(new Member(1L,"tester", Grade.VIP));

        // 생성자 주입을 선택했기에 의존성 주입을 해주지 않는다면 컴파일 에러가 발생한다.
        OrderServiceImpl orderService =
                new OrderServiceImpl(
                        new MemoryMemberRepository(), new FixDiscountPolicy()
                );

        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
