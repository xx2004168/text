package com.mdxq.mall.user.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.RoleResourceRelation;
import com.mdxq.mall.user.service.RoleResourceRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/roleResourceRelation")
public class RoleResourceRelationController {

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    /**
     * 添加。
     *
     * @param roleResourceRelation 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody RoleResourceRelation roleResourceRelation) {
        return roleResourceRelationService.save(roleResourceRelation);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return roleResourceRelationService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param roleResourceRelation 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody RoleResourceRelation roleResourceRelation) {
        return roleResourceRelationService.updateById(roleResourceRelation);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<RoleResourceRelation> list() {
        return roleResourceRelationService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public RoleResourceRelation getInfo(@PathVariable Long id) {
        return roleResourceRelationService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<RoleResourceRelation> page(Page<RoleResourceRelation> page) {
        return roleResourceRelationService.page(page);
    }

}
