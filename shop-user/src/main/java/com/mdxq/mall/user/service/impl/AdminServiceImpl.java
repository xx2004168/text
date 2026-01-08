package com.mdxq.mall.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.user.entity.AdminLoginLog;
import com.mdxq.mall.user.entity.AdminRoleRelation;
import com.mdxq.mall.user.mapper.AdminLoginLogMapper;
import com.mdxq.mall.user.service.AdminRoleRelationService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.Admin;
import com.mdxq.mall.user.mapper.AdminMapper;
import com.mdxq.mall.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>  implements AdminService{

    // 装配一个登录日志Mapper
    @Autowired
    private AdminLoginLogMapper adminLoginLogMapper;

    // 重写getById方法，注入角色和菜单数据
    @Override
    public Admin getById(Serializable id) {
        Admin admin = super.getById(id);// 先调用父类的getBuId查询到管理员的信息
        admin.setRoles(mapper.selectRolesByAdminId(admin.getId()));// 像管理员实例注入角色列表
        admin.setMenus(mapper.selectMenusByAdminId(admin.getId()));// 注入菜单列表
        return admin;
    }

    @Override
    public Admin login(String username, String password, HttpServletRequest request) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //                    表的用户名字段 客户端填写的用户名
        queryWrapper.eq("username", username);
        queryWrapper.eq("status", 1);// 查询状态为1（正常使用）的账号
        // 使用getOne方法需要保证查到的结果最多是一条，否则会抛异常
        Admin admin = this.getOne(queryWrapper);
        if (admin != null) {// 说明查到了这个账号，且状态正常
            // 第一个参数是用户填写的密码，第二个参数是数据库查到的加密后的密码
            if (BCrypt.checkpw(password, admin.getPassword())) {// 校验通过返回true
//                UpdateWrapper updateWrapper = UpdateWrapper.of(Admin.class);
                admin.setLoginTime(LocalDateTime.now());// 修改登录时间
//                updateWrapper.set("loginTime", LocalDateTime.now());
                mapper.updateByQuery(admin, true, queryWrapper);
                // 封装一个登录日志的实例
                AdminLoginLog adminLoginLog = new AdminLoginLog();
                adminLoginLog.setAdminId(admin.getId());
                adminLoginLog.setIp(request.getRemoteHost());// 设置客户端IP
                adminLoginLog.setAddress(request.getRemoteAddr());
                adminLoginLog.setCreateTime(LocalDateTime.now());
                adminLoginLog.setUserAgent(request.getHeader("user-agent"));
                adminLoginLogMapper.insert(adminLoginLog);
                return admin;
            }
        }
        return null;
    }

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;

    @Override
    @Transactional
    public boolean allocRole(Long adminId, String roleIds) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("admin_id", adminId);
        adminRoleRelationService.remove(queryWrapper);
        if (StrUtil.isNotBlank(roleIds)) {
            List<AdminRoleRelation> list = new ArrayList<>();
            for (String roleId : roleIds.split(",")) {
                list.add(new AdminRoleRelation(null, adminId, Long.valueOf(roleId)));
            }
            adminRoleRelationService.saveBatch(list);
        }
        return true;
    }
}
