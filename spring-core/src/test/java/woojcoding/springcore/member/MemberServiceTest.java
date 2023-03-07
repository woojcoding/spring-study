package woojcoding.springcore.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woojcoding.springcore.AppConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setup() {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
    }

    @Test
    void join() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        //then
        assertThat(member).isEqualTo(findMember);
    }
}
