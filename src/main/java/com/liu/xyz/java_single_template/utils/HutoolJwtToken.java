package com.liu.xyz.java_single_template.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * create lzh 2023-06-03
 *
 * @description
 */
public class HutoolJwtToken {



    public static  String createToken(Integer userId,String username){
//        byte[] bytes={1,2,3,4};//定义byte数组的原因是因为JWTUtil.createToken(map,byte[])需要两个参数，其中一个为byte[]
        byte[] bytes= "lzhyyds".getBytes(StandardCharsets.UTF_8);
        /**
         * hutool的时间工具包
         * now 定义为jwt的签发时间 生效时间
         */
        DateTime now = DateTime.now();
        //System.out.println(now);//2022-07-21 10:11:43
        DateTime dateTime = now.offsetNew(DateField.MILLISECOND, 1);//jwt的过期时间  当前时间+100;
        System.out.println(dateTime);//2122-07-21 10:14:54

        HashMap<String, Object> map = new HashMap<>();//JWTUtil.createToken(map,byte[])一个参数为map类型
        //签发时间
        map.put(JWTPayload.ISSUED_AT, now);
        //过期时间
        map.put(JWTPayload.EXPIRES_AT, dateTime);
        //生效时间
        map.put(JWTPayload.NOT_BEFORE, now);
        /**
         * 载荷
         * 放了一个用户id ，角色权限  用户密码
         */


        map.put("userId",userId);
        map.put("username", username);

        //map.put("pwdMd5",pwdMd5);
        String token = JWTUtil.createToken(map, bytes);
        System.out.println(token);
        return  token;
    }


    public static String getUsername(String rightToken){
        final JWT jwt = JWTUtil.parseToken(rightToken);
        String username =(String) jwt.getPayload().getClaim("username");

        return username;
    }
}
