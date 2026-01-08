package com.mdxq.mall.sale.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.CouponProductCategoryRelation;
import com.mdxq.mall.sale.service.CouponProductCategoryRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/couponProductCategoryRelation")
public class CouponProductCategoryRelationController {

    @Autowired
    private CouponProductCategoryRelationService couponProductCategoryRelationService;

    /**
     * 添加。
     *
     * @param couponProductCategoryRelation 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
        return couponProductCategoryRelationService.save(couponProductCategoryRelation);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return couponProductCategoryRelationService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param couponProductCategoryRelation 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
        return couponProductCategoryRelationService.updateById(couponProductCategoryRelation);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<CouponProductCategoryRelation> list() {
        return couponProductCategoryRelationService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public CouponProductCategoryRelation getInfo(@PathVariable Long id) {
        return couponProductCategoryRelationService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<CouponProductCategoryRelation> page(Page<CouponProductCategoryRelation> page) {
        return couponProductCategoryRelationService.page(page);
    }

}
