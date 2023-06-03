package com.liu.xyz.java_single_template.service;

import com.liu.xyz.java_single_template.model.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lzh
 * @since 2023-06-03
 */
public interface AdminService extends IService<Admin> {

    String login(String username, String password);
}
