package com.hqj.train.member.service.Impl;

import cn.hutool.core.collection.CollUtil;
import com.hqj.train.common.exception.BusinessException;
import com.hqj.train.common.exception.BusinessExceptionEnum;
import com.hqj.train.member.domain.Member;
import com.hqj.train.member.domain.MemberExample;
import com.hqj.train.member.mapper.MemberMapper;
import com.hqj.train.member.req.MemberRegisterReq;
import com.hqj.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Override
    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(members)) {
            //return members.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
