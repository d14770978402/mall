package com.deng.malltiny.controller;

import com.deng.malltiny.common.api.CommonResult;
import com.deng.malltiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "UmsMemberController",value="会员登入注册Controller")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    UmsMemberService umsMemberService;
    @ApiOperation("获取验证码")
    @RequestMapping("/getAuthCode")
    public CommonResult<String> generateAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }
    @ApiOperation("判断验证码是否正确")
    @RequestMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}
