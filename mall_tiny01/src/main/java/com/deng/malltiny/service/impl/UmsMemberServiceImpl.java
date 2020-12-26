package com.deng.malltiny.service.impl;

import com.deng.malltiny.common.api.CommonResult;
import com.deng.malltiny.service.RedisService;
import com.deng.malltiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 *会员管理service实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    RedisService redisService;
    @Value("${redis.key.prefix.authcode}")
    String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authcode}")
    long AUTH_CODE_EXPIRE_SECONDS;
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success("成功获取验证码",sb.toString());
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请填写验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        boolean result = realAuthCode.equals(authCode);
        if(result){
            return CommonResult.success("验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }

    }
}
