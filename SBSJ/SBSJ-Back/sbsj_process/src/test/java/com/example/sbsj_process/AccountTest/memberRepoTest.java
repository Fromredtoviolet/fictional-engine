package com.example.sbsj_process.AccountTest;


import com.example.sbsj_process.account.repository.AuthenticationRepository;
import com.example.sbsj_process.account.repository.MemberRepository;
import com.example.sbsj_process.account.service.MemberService;

import com.example.sbsj_process.account.service.request.MemberRegisterRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("실제 DB에 Member 테스트")
@SpringBootTest
public class memberRepoTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Test
    public void 멤버_회원가입_테스트() {
        MemberRegisterRequest memberRegisterRequest =
                new MemberRegisterRequest(
                        "남건호", "test", "test", "test@test.com", "19920824","01062643016");
        boolean successSignUp = memberService.signUp(memberRegisterRequest);
        if(successSignUp) {
            System.out.println("회원 가입 완료!");
        } else {
            System.out.println("회원 가입이 정상적으로 처리되지 않았습니다.");
        }
    }
}
