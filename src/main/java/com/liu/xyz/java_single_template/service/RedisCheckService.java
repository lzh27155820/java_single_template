package com.liu.xyz.java_single_template.service;

import com.liu.xyz.java_single_template.model.Admin;

/**
 * create lzh 2023-06-03
 *
 * @description
 */
public interface RedisCheckService {

    void setAdmin(Admin admin);

    Admin getAdmin(String username);
}
