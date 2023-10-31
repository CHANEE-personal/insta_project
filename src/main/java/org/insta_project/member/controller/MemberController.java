package org.insta_project.member.controller;

import lombok.RequiredArgsConstructor;
import org.insta_project.member.domain.IdCheckResponse;
import org.insta_project.member.domain.LoginRequest;
import org.insta_project.member.domain.LoginResponse;
import org.insta_project.member.domain.MemberDTO;
import org.insta_project.member.domain.MemberEntity;
import org.insta_project.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/join")
    public ResponseEntity<MemberEntity> saveMember(@RequestBody MemberDTO member) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserName(member.getUserName());
        memberEntity.setUserId(member.getUserId());
        memberEntity.setPassword(member.getPassword());
        memberEntity.setAddress(member.getAddress());
        memberEntity.setGender(member.getGender());
        memberEntity.setBirthDay(member.getBirthDay());
        memberEntity.setUserPhone(member.getUserPhone());
        memberEntity.setEmail(member.getEmail());
        MemberEntity saveMember = memberService.save(memberEntity);
        return ResponseEntity.ok(saveMember);
    }


    @GetMapping("/check")
    public ResponseEntity<IdCheckResponse> checkUserId(@RequestParam("userId") String userId) {
        return ResponseEntity.ok(memberService.checkUserId(userId));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(memberService.login(loginRequest));
    }
}
