package woojcoding.springcore.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woojcoding.springcore.AppConfig;
import woojcoding.springcore.member.MemberRepository;
import woojcoding.springcore.member.MemberServiceImpl;
import woojcoding.springcore.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService =
                ac.getBean("memberService", MemberServiceImpl.class);

        OrderServiceImpl orderService =
                ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository =
                ac.getBean("memberRepository", MemberRepository.class);

        assertThat(memberService.getMemberRepository())
                .isSameAs(memberRepository);

        assertThat(orderService.getMemberRepository())
                .isSameAs(memberRepository);
    }
    
    @Test
    void ConfigurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = ac.getBean("appConfig", AppConfig.class);

        //class woojcoding.springcore.AppConfig$$EnhancerBySpringCGLIB$$bec7eab0
        System.out.println("appConfig.getClass() = " + appConfig.getClass());
    }
}
