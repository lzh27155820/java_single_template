package com.liu.xyz.java_single_template;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

@SpringBootTest
class JavaSingleTemplateApplicationTests {

    @Autowired
    public RedisTemplate redisTemplate;
    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("kkkk","lsls");
    }

    public static void main(String[] args) throws InterruptedException {
        String rightToken = createToken();



        Thread.sleep(1000);
        // 由于只定义了签发时间，因此只检查签发时间
        //JWTValidator date = JWTValidator.of(rightToken).validateDate(DateUtil.date());

        final JWT jwt = JWTUtil.parseToken(rightToken);
        Object userId = jwt.getPayload().getClaim("userId");
        String pwdMd5 =(String) jwt.getPayload().getClaim("pwdMd5");
//        System.out.println(date.);
        System.out.println(pwdMd5);
        System.out.println(userId);
        System.out.println(jwt);
    }

    static  String createToken(){
        byte[] bytes={1,2,3,4};//定义byte数组的原因是因为JWTUtil.createToken(map,byte[])需要两个参数，其中一个为byte[]
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

        String userId = IdUtil.fastSimpleUUID();
        map.put("userId",userId);
        map.put("role", 0);
        String pwd="123456";
        String pwdMd5 ="nwuwuw"; // SecureUtil.md5(pwd);//hutool工具包的MD5加密 也可以使用spring家的md5
        map.put("pwdMd5",pwdMd5);
        String token = JWTUtil.createToken(map, bytes);
        System.out.println(token);
        return  token;
    }
}
