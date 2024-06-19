package com.hqj.train.member.controller;


import com.hqj.train.common.resp.CommonResp;
import com.hqj.train.member.req.MemberLoginReq;
import com.hqj.train.member.req.MemberRegisterReq;
import com.hqj.train.member.req.MemberSendCodeReq;
import com.hqj.train.member.resp.MemberLoginResp;
import com.hqj.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        return new CommonResp<>(count);
    }
    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req) {
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }
    @PostMapping("/send-code")
    public CommonResp<Long> sendcode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp> sendcode(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }
}
