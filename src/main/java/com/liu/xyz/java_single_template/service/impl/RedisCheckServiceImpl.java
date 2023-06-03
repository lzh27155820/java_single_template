package com.liu.xyz.java_single_template.service.impl;

import com.liu.xyz.java_single_template.common.service.RedisService;
import com.liu.xyz.java_single_template.model.Admin;
import com.liu.xyz.java_single_template.service.RedisCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * create lzh 2023-06-03
 *
 * @description
 */
@Service
public class RedisCheckServiceImpl implements RedisCheckService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
    @Override
    public void setAdmin(Admin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public Admin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (Admin) redisService.get(key);
    }


}
