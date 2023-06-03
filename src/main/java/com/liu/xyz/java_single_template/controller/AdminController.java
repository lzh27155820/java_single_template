package com.liu.xyz.java_single_template.controller;


import com.liu.xyz.java_single_template.common.CommonResult;
import com.liu.xyz.java_single_template.model.Admin;
import com.liu.xyz.java_single_template.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author lzh
 * @since 2023-06-03
 */
@Tag(name = "dhqudhduwghwd")
@RestController
@RequestMapping("/java_single_template/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping("")
    public CommonResult<Admin> eader(@RequestHeader("token") String token){
        Admin user = new Admin();
        user.setUsername("dhudgw");
//        user.setId("1");
        return CommonResult.success(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login( @RequestBody Admin umsAdminLoginParam) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
      //  tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


}

