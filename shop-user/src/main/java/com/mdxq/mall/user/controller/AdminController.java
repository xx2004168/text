package com.mdxq.mall.user.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.user.dto.UserLoginDTO;
import com.mdxq.mall.user.entity.AdminRoleRelation;
import com.mdxq.mall.user.service.AdminRoleRelationService;
import com.mdxq.mall.user.service.RoleService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.Admin;
import com.mdxq.mall.user.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("login")
    public R login(@RequestBody UserLoginDTO dto, HttpServletRequest request) {
        Admin admin = adminService.login(dto.getUsername(), dto.getPassword(), request);
        if (admin != null) {
            Map<String, Object> payload = new HashMap<String, Object>() {
                {
                    put("id", admin.getId());
                    put("username", admin.getUsername());
                    put("nikeName", admin.getNickName());
                    // 将签发令牌时的系统时间戳放到 payload 里
                    put("iat", System.currentTimeMillis());//令牌签发时间
                    put("exp", 1 * 60 * 60 * 1000L);//令牌的有效时长
                }
            };
            String token = JWTUtil.createToken(payload, "md-mall-0112".getBytes());//创建令牌
            // 向Redis缓存中存入用户登陆生成的token
            redisTemplate.opsForValue().set(token, null);
            // 令牌在一个小时之内有效
            redisTemplate.expire(token, 10, TimeUnit.HOURS);
            return R.ok(token);//向客户端返回令牌
        }
        // HttpStatus.UNAUTHORIZED 表示 401，未授权
        return R.error();
    }

    /**
     * 登出功能
     * @param token
     * @return
     */
    @PostMapping("logout")
    public R logout(@RequestHeader("authorization") String token) {
        // 之后加上Redis，需要在登出系统时，让Redis中的token过期
        redisTemplate.delete(token);
        return R.ok(true);
    }


    /**
     * 添加。
     *
     * @param admin 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Admin admin) {
        admin.setCreateTime(LocalDateTime.now());
        if (adminService.save(admin)) {
            return R.ok(true);
        } else {
            return R.error();
        }
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(adminService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param admin 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody Admin admin) {
        return R.ok(adminService.updateById(admin));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(adminService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param token 主键
     * @return 详情
     */
    @GetMapping("getInfo")
    public R getInfo(@RequestHeader("authorization") String token) {
        // 解析请求头中的token令牌，从中获取当前登录的管理员ID
        JWT jwt = JWTUtil.parseToken(token);
        int adminId = Integer.valueOf(jwt.getPayload("id").toString());
        Admin admin = adminService.getById(adminId);
        return R.ok(admin);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Admin> page, String keyWord) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("username", keyWord).like("nick_name", keyWord);
        return R.ok(adminService.page(page,queryWrapper));
    }

    @Autowired
    private AdminRoleRelationService adminRoleRelationService;

    @Autowired
    private RoleService roleService;

    @GetMapping("role/{id}")
    public R getRoleByAdmin(@PathVariable Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("admin_id", id);
        queryWrapper.select("role_id");
        List<Long> roleIds = adminRoleRelationService.listAs(queryWrapper, Long.class);
        if (CollUtil.isNotEmpty(roleIds)) {
            return R.ok(roleService.listByIds(roleIds));
        } else {
            return R.ok(Collections.emptyList());
        }
    }

    @PostMapping("role/update")
    public R allocRole(@RequestParam Long adminId, @RequestParam String roleIds) {
        return R.ok(adminService.allocRole(adminId, roleIds));
    }

    @PostMapping("updateStatus/{id}")
    public R updateStatus(@PathVariable Long id, @RequestParam int status) {
        Admin admin = adminService.getById(id);
        if (admin != null) {
            admin.setStatus(status);
            adminService.updateById(admin);
            return R.ok(true);
        } else {
            return R.error();
        }

    }

}
