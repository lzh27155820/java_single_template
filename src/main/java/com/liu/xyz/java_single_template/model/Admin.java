package com.liu.xyz.java_single_template.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author lzh
 * @since 2023-06-03
 */
@Getter
@Setter
@Schema(name = "Admin对象", description = "后台用户表")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @Schema(description="账号")
    private String username;
    @Schema(description="密码")
    private String password;

    @Schema(description="头像")
    private String icon;

    @Schema(description="邮箱")
    private String email;

    @Schema(description="昵称")
    private String nickName;

    @Schema(description="备注信息")
    private String note;

    @Schema(description="创建时间")
    private Date createTime;

    @Schema(description="最后登录时间")
    private Date loginTime;

    @Schema(description="帐号启用状态：0->禁用；1->启用")
    private Integer status;


}
