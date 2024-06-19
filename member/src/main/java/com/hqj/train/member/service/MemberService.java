package com.hqj.train.member.service;

import com.hqj.train.member.req.MemberRegisterReq;
import org.springframework.stereotype.Service;

/**
 * ClassName: MemberService
 * Package: com.hqj.train.member.service
 * Description:
 *
 * @Author:HQJ
 * @Create:2024/6/18 - 16:21
 * @Version v1.0
 */
@Service
public interface MemberService {

    int count();

    long register(MemberRegisterReq req);
}
