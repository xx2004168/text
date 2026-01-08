package com.mdxq.mall.user.mapper;

import com.mdxq.mall.user.entity.Menu;
import com.mdxq.mall.user.entity.Role;
import com.mybatisflex.core.BaseMapper;
import com.mdxq.mall.user.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  映射层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from ums_role where id in\n" +
            "(select role_id from ums_admin_role_relation where admin_id=#{param1})")
    List<Role> selectRolesByAdminId(Long adminId);

    @Select("select * from ums_menu where id in\n" +
            "(select menu_id from ums_role_menu_relation where role_id in\n" +
            "                             (select role_id from ums_admin_role_relation where admin_id=#{param1}))")
    List<Menu> selectMenusByAdminId(Long adminId);
}
