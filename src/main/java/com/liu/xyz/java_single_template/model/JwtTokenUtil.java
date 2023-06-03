//package com.liu.xyz.java_single_template.model;
//
//
//import cn.hutool.core.codec.Base64;
//import cn.hutool.jwt.Claims;
//import io.jsonwebtoken.Jwts;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.security.Key;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Description: Token工具类 Created on 2019/10/14 15:37
// *
// * @author <a href="mailto: Tablo_Jhin1996@outlook.com">Tablo</a>
// * @version 1.0
// */
//@Data
//@ConfigurationProperties(prefix = "jwt")
//@EnableConfigurationProperties(JwtTokenUtil.class)
//@Component
//public class JwtTokenUtil implements Serializable {
//
//    private static final String CLAIM_KEY_USER_ACCOUNT = "sub";
//
//    private static final String CLAIM_KEY_CREATED = "created";
//
//    /** 秘钥 */
//    private String secret="lzhyyds";
//
//    /** 过期时间 */
//    private Long expiration=100000000l;
//
//    private String tokenHeader="lzhyyds";
//
//    private String tokenHead;
//
//    private String[] exceptUrl;
//
//    private String[] mustUrl;
//
//    /**
//     * .Created on 17:22 2019/10/17 Author: Tablo.
//     *
//     * <p>Description:[判定是否需要校验Token]
//     *
//     * @param exceptUrls 排除的Url
//     * @param path 请求路径
//     * @return boolean
//     */
//    public static boolean judgeIsCheck(String[] mustUrls, String[] exceptUrls, String path) {
//        if (Arrays.stream(mustUrls).anyMatch(path::startsWith)) {
//            return false;
//        }
//        return Arrays.stream(exceptUrls).anyMatch(path::startsWith);
//    }
//
//    /**
//     * 从数据声明生成令牌
//     *
//     * @param claims 数据声明
//     * @return 令牌
//     */
////    private String generateToken(Map<String, Object> claims) {
////        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
////    }
//    /**
//     * 从数据声明生成令牌
//     *
//     * @param claims 数据声明
//     * @return 令牌
//     */
//    private String generateToken(Map<String, Object> claims) {
//        String encode = Base64.encode(secret);//原本这里secret在jjwt0.9.1之后的版本中直接decode失败，在jjwt0.9.1及之前的版本可以成功解密，所以这里我相当于又给它加密解密，
//        byte[] keyBytes = Decoders.BASE64.decode(encode); //这里先转码成base64又转回来，0.9.1之后只推荐使用key的形式sign，所以上面那个解密jwt会有Base64.encode(secret)，因为实际上我的加密secret变成了现在的加密后的secret
//        Key key = Keys.hmacShaKeyFor(keyBytes);
//        return Jwts.builder().setClaims(claims).signWith(key).compact();
//    }
//
//    /**
//     * 从令牌中获取数据声明
//     *
//     * @param token 令牌
//     * @return 数据声明
//     */
//    private Claims getClaimsFromToken(String token) {
//        Claims claims;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token).getBody();
//        } catch (Exception e) {
//            claims = null;
//        }
//        return claims;
//    }
//
//    /**
//     * 生成令牌
//     *
//     * @param userDetails 用户
//     * @return 令牌
//     */
//    public String generateToken(Admin userDetails) {
//        Map<String, Object> claims = new HashMap<>(2);
//        claims.put(CLAIM_KEY_USER_ACCOUNT, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }
//
//    /**
//     * 从令牌中获取用户名
//     *
//     * @param token 令牌
//     * @return 用户名
//     */
//    public String getUsernameFromToken(String token) {
//        String username;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            username = claims.getSubject();
//        } catch (Exception e) {
//            username = null;
//        }
//        return username;
//    }
//
//    /**
//     * 判断令牌是否过期
//     *
//     * @param token 令牌
//     * @return 是否过期
//     */
//    public Boolean isTokenExpired(String token) {
//        try {
//            Claims claims = getClaimsFromToken(token);
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * 刷新令牌
//     *
//     * @param token 原令牌
//     * @return 新令牌
//     */
//    public String refreshToken(String token) {
//        String refreshedToken;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            claims.put("created", new Date());
//            refreshedToken = generateToken(claims);
//        } catch (Exception e) {
//            refreshedToken = null;
//        }
//        return refreshedToken;
//    }
//
//    /**
//     * 验证令牌
//     *
//     * @param token 令牌
//     * @param user 用户
//     * @return 是否有效
//     */
//    public Boolean validateToken(String token, Admin user) {
//        String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername()));
//    }
//
//    public static void main(String[] args) {
//        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
//        Admin admin = new Admin();
//        admin.setUsername("jjjj");
//        admin.setPassword("xxx");
//        admin.setId(1);
//        String s = jwtTokenUtil.generateToken(admin);
//
//        System.out.println(s);
//    }
//
//
//
//}
//
