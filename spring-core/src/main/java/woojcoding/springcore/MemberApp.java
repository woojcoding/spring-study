package woojcoding.springcore;

import woojcoding.springcore.member.Grade;
import woojcoding.springcore.member.Member;
import woojcoding.springcore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
