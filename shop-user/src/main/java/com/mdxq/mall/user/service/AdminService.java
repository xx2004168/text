package com.mdxq.mall.user.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.user.entity.Admin;

import javax.servlet.http.HttpServletRequest;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface AdminService extends IService<Admin> {
    /**
     * 管理员登录
     * @param username 账号
     * @param password 密码
     * @return 登录成功返回管理员对象，失败返回null
     */
    Admin login(String username, String password, HttpServletRequest request);


    boolean allocRole(Long adminId, String roleIds);
}
