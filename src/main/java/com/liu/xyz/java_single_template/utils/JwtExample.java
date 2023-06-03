//package com.liu.xyz.java_single_template.utils;
//
///**
// * create lzh 2023-06-03
// *
// * @description
// */
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import javax.json.bind.Jsonb;
//import javax.json.bind.JsonbBuilder;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//
//public class JwtExample {
//    private static final String SECRET_KEY = "your-secret-key"; // 替换为你自己的密钥
//
//    public static void main(String[] args) {
//        // 创建JWT
//        String jwt = createJwt("user123", 3600);
//        System.out.println("JWT: " + jwt);
//
//        // 验证JWT
//        boolean isValid = validateJwt(jwt);
//        System.out.println("Is Valid: " + isValid);
//
//        // 获取JWT的主题
//        String subject = getSubjectFromJwt(jwt);
//        System.out.println("Subject: " + subject);
//    }
//
//    public static String createJwt(String subject, long expirationInSeconds) {
//        Key key = generateKey();
//        long currentTimeInSeconds = System.currentTimeMillis() / 1000;
//
//        JwtPayload payload = new JwtPayload();
//        payload.setSub(subject);
//        payload.setIat(currentTimeInSeconds);
//        payload.setExp(currentTimeInSeconds + expirationInSeconds);
//
//        Jsonb jsonb = JsonbBuilder.create();
//        String payloadJson = jsonb.toJson(payload);
//
//        String header = Base64.getUrlEncoder().encodeToString("{\"alg\":\"HS256\"}".getBytes(StandardCharsets.UTF_8));
//        String payloadBase64 = Base64.getUrlEncoder().encodeToString(payloadJson.getBytes(StandardCharsets.UTF_8));
//
//        String signature = HmacUtils.calculateHmacSha256(header + "." + payloadBase64, key);
//
//        return header + "." + payloadBase64 + "." + signature;
//    }
//
//    public static boolean validateJwt(String jwt) {
//        String[] parts = jwt.split("\\.");
//
//        String header = parts[0];
//        String payloadBase64 = parts[1];
//        String signature = parts[2];
//
//        Key key = generateKey();
//        String expectedSignature = HmacUtils.calculateHmacSha256(header + "." + payloadBase64, key);
//
//        return signature.equals(expectedSignature);
//    }
//
//    public static String getSubjectFromJwt(String jwt) {
//        String[] parts = jwt.split("\\.");
//
//        String payloadBase64 = parts[1];
//        byte[] payloadBytes = Base64.getUrlDecoder().decode(payloadBase64);
//        String payloadJson = new String(payloadBytes, StandardCharsets.UTF_8);
//
//        Jsonb jsonb = JsonbBuilder.create();
//        JwtPayload payload = jsonb.fromJson(payloadJson, JwtPayload.class);
//
//        return payload.getSub();
//    }
//
//    private static Key generateKey() {
//        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
//        SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacSHA256");
//        return secretKey;
//    }
//}
//
