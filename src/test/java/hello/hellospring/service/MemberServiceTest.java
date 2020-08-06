package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService=new MemberService();
    /*
    테스트 코드는 함수명을 한글로 작성해도 동작함
     */
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("test1");

        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertThat(saveId).isEqualTo(member.getId());
        
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}