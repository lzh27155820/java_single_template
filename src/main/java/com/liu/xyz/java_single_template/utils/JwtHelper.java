//package com.liu.xyz.java_single_template.utils;
///*
// *@date 2022/7/14-21:13
// */
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.CompressionCodecs;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.Map;
//
//@Slf4j
//@Component
//public class JwtHelper {
//    //token字符串有效时间
//    private static long tokenExpiration =24*60*60*1000;
//    private static final String SECRET_KEY = "3F4428472B4B6250655368566D5971337336763979244226452948404D635166";
//
//    //加密编码秘钥
//    private static String tokenSignKey = "liuyyds";
//    private static Key getSignInKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//    //根据userid  和  username 生成token字符串
//    public static String createToken(Integer userId, String userName) {
//        String token = Jwts.builder()
//                //设置token分类
//                .setSubject("ADMIN-TEMPLATE")
//
//                //token字符串有效时长
//                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
//                //私有部分（用户信息）
//                .claim("userId", userId)
//                .claim("userName", userName)
//                //根据秘钥使用加密编码方式进行加密，对字符串压缩
//
////                .signWith(SignatureAlgorithm.PS256, tokenSignKey)
//                .compressWith(CompressionCodecs.GZIP)
//
//                .compact();
//        return token;
//    }
////    public static String checkTokenKeyId(HttpServletRequest request) {
////        try {
////            String jwtToken = request.getHeader("token");
////            if(StringUtils.isEmpty(jwtToken)) return null;
////            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(jwtToken);
////            Claims body = claimsJws.getBody();
////           return (String) body.get("userId");
////        } catch (Exception e) {
////            e.printStackTrace();
////
////        }
////        return null;
////    }
////    public static boolean  checkToken(HttpServletRequest request) {
////        try {
////            String jwtToken = request.getHeader("token");
////            if(StringUtils.isEmpty(jwtToken)) return false;
////            Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(jwtToken);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return false;
////        }
////        return true;
////    }
//    //从token字符串获取userid
//    public static Integer getUserId(String token) {
//        if(StringUtils.isEmpty(token)) return null;
//        Claims claims = getClaimsFromToken(token);
//
//        Integer userId = (Integer)claims.get("userId");
//        return userId;
//    }
//
//    //从token字符串获取getUserName
//    public static String getUserName(String token) {
//        if(StringUtils.isEmpty(token)) return null;
//        Claims claims = getClaimsFromToken(token);
//        if(claims==null) return null;
//        String userName = (String)claims.get("userName");
//        return userName;
//    }
//
//    /**
//     * 验证token是否还有效
//     *
//     * @param token       客户端传入的token
//     * @param username 从数据库中查询出来的用户信息
//     */
//    public  static boolean validateToken(String token, String username) {
//        String user = getUserName(token);
//        return user.equals(username) && !isTokenExpired(token);
//    }
//    /**
//     * 判断token是否已经失效
//     * true 失效
//     * false 有效
//     */
//    private static boolean isTokenExpired(String token) {
//        Claims claims = getClaimsFromToken(token);
//        if(claims==null)return true;
//        Date expiredDate = claims.getExpiration();
//        return expiredDate.before(new Date());
//    }
//    /**
//     * 从token中获取过期时间
//     */
//    private static Date getExpiredDateFromToken(String token) {
//        Claims claims = getClaimsFromToken(token);
//        return claims.getExpiration();
//    }
//    /**
//     * 从token中获取JWT中的负载
//     */
//    private static Claims getClaimsFromToken(String token) {
//        Claims claims = null;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(tokenSignKey)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            log.info("JWT格式验证失败:{}", token);
//        }
//        return claims;
//    }
//
//    /**
//     * 从数据声明生成令牌
//     *
//     * @param claims 数据声明
//     * @return 令牌
//     */
//    private static String generateToken(Map<String, Object> claims) {
////        String encode = Base64.encode(secret); //现在我新生成的secret字符合法了，并且可以解密，不用再加密后当secret用了
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        Key key = Keys.hmacShaKeyFor(keyBytes);
//        return Jwts.builder().setClaims(claims).signWith(key).compact();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
////        generateToken()
//
//        String token = JwtHelper.createToken(1, "lucy");
////        Thread.sleep(6000);
//        System.out.println(token);
//
//
////        System.out.println(JwtHelper.getUserId(token));
////        System.out.println(JwtHelper.getUserName(token));
////
////        boolean expired = JwtHelper.isTokenExpired(token);
////        System.out.println(expired);
//    }
//}
