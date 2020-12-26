package com.deng.malltiny.service;

import com.deng.malltiny.common.api.CommonResult;

public interface UmsMemberService {
    CommonResult generateAuthCode(String telephone);
    CommonResult verifyAuthCode(String telephone,String authCode);
}
