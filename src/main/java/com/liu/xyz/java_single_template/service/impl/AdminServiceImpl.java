package com.liu.xyz.java_single_template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.xyz.java_single_template.mapper.AdminMapper;
import com.liu.xyz.java_single_template.model.Admin;
import com.liu.xyz.java_single_template.service.AdminService;
import com.liu.xyz.java_single_template.service.RedisCheckService;
import com.liu.xyz.java_single_template.utils.HutoolJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.liu.xyz.java_single_template.utils.JwtService;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lzh
 * @since 2023-06-03
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private RedisCheckService redisCheckService;
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//    @Autowired
//    private JwtService jwtService;
    @Override
    public String login(String username, String password) {
        System.out.println("xxxx");
        Admin admin = redisCheckService.getAdmin(username);

        if(admin==null){
            admin=this.getOne(new QueryWrapper<Admin>().eq("username",username).eq("password",password));
        }
        if(admin!=null){
            redisCheckService.setAdmin(admin);

            String token = HutoolJwtToken.createToken(admin.getId(),admin.getUsername());

            return token;
        }


        return null;
    }
}
