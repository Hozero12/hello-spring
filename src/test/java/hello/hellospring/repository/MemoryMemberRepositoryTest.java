package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("hoyoung1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hoyoung2");
        repository.save(member2);

        Member result=repository.findByName("hoyoung2").get();

        assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("hoyoung");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("subin");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("hoyoung2");
        repository.save(member3);

        List<Member> result= repository.findAll();

        assertThat(result.size()).isEqualTo(3);

    }
}


