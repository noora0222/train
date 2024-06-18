package com.hqj.train.member.service.Impl;

import com.hqj.train.member.mapper.MemberMapper;
import com.hqj.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: MemberServiceImpl
 * Package: com.hqj.train.member.service.Impl
 * Description:
 *
 * @Author:HQJ
 * @Create:2024/6/18 - 16:22
 * @Version v1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;
    @Override
    public int count() {
        return (int) memberMapper.countByExample(null);
    }
}
