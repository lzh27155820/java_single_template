package com.liu.xyz.java_single_template.mapper;

import com.liu.xyz.java_single_template.model.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author lzh
 * @since 2023-06-03
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
