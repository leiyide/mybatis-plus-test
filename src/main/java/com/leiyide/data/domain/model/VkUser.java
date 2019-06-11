package com.leiyide.data.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * vk_user
*/
@Data
@TableName("vk_user")
public class VkUser implements Serializable {
    /**
     * 用户id
     */
	@TableId("user_id")
    private Integer userId;

    /**
     * 用户名
     */
	@TableField("user_name")
    private String userName;

    /**
     * 密码
     */
	@TableField("password")
    private String password;

    /**
     * 性别（0：男，1：女）
     */
	@TableField("sex")
    private Boolean sex;

    /**
     * 手机号
     */
	@TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
	@TableField("email")
    private String email;

    /**
     * 状态（0：不可用，1：可用）
     */
	@TableField("status")
    private Boolean status;

    /**
     * 部门id
     */
	@TableField("dept_id")
    private Integer deptId;

    /**
     * 登录时间
     */
	@TableField("login_time")
    private Date loginTime;

    /**
     * 登录ip
     */
	@TableField("login_ip")
    private String loginIp;

    /**
     * 创建人
     */
	@TableField("create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
	@TableField("create_time")
    private Date createTime;

    /**
     * 修改人
     */
	@TableField("update_user")
    private Integer updateUser;

    /**
     * 修改时间
     */
	@TableField("update_time")
    private Date updateTime;

    /**
     * 配合密码加密的盐
     */
	@TableField("salt")
    private String salt;

    /**
     * vk_user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别（0：男，1：女）
     * @return sex 性别（0：男，1：女）
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 性别（0：男，1：女）
     * @param sex 性别（0：男，1：女）
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 手机号
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 状态（0：不可用，1：可用）
     * @return status 状态（0：不可用，1：可用）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 状态（0：不可用，1：可用）
     * @param status 状态（0：不可用，1：可用）
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 部门id
     * @return dept_id 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 部门id
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 登录时间
     * @return login_time 登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm：ss", timezone = "GMT+8")
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登录时间
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登录ip
     * @return login_ip 登录ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登录ip
     * @param loginIp 登录ip
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 创建人
     * @return create_user 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     * @param createUser 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm：ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_user 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     * @param updateUser 修改人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm：ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 配合密码加密的盐
     * @return salt 配合密码加密的盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 配合密码加密的盐
     * @param salt 配合密码加密的盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}