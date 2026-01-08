package com.mdxq.mall.product.controller;

import cn.hutool.core.collection.CollUtil;
import com.mdxq.mall.product.entity.ProductCategoryAttributeRelation;
import com.mdxq.mall.product.service.ProductCategoryAttributeRelationService;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.product.entity.ProductAttribute;
import com.mdxq.mall.product.service.ProductAttributeService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/productAttribute")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @Autowired
    private ProductCategoryAttributeRelationService relationService;

    /**
     * 添加。
     *
     * @param productAttribute 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.save(productAttribute);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return productAttributeService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param productAttribute 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.updateById(productAttribute);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<ProductAttribute> list() {
        return productAttributeService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public ProductAttribute getInfo(@PathVariable Long id) {
        return productAttributeService.getById(id);
    }

    @GetMapping("attrInfo/{productCategoryId}")
    public R attrInfo(@PathVariable Long productCategoryId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("product_attribute_id");
        queryWrapper.eq("product_category_id", productCategoryId);
        // 访问商品类别-属性关联表，查询这个商品类别下关联的所有属性ID
        List<Long> attrIdList = relationService.listAs(queryWrapper, Long.class);
        if (CollUtil.isEmpty(attrIdList)) {// 如果没有查到关联数据直接返回空集合
            return R.ok(Collections.emptyList());
        }
        queryWrapper.clear();
        queryWrapper.select("id as attributeId");
        queryWrapper.select("product_attribute_category_id as attributeCategoryId");
        queryWrapper.in("id", attrIdList);
        return R.ok(productAttributeService.listAs(queryWrapper, HashMap.class));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page/{cid}")
    public R page(Page<ProductAttribute> page, @PathVariable Integer cid, @RequestParam Integer type) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_attribute_category_id", cid);
        queryWrapper.eq("type", type);
        return R.ok(productAttributeService.page(page, queryWrapper));
    }

}
