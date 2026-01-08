package com.mdxq.mall.product.controller;

import com.mdxq.mall.product.service.ProductAttributeService;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.product.entity.ProductAttributeCategory;
import com.mdxq.mall.product.service.ProductAttributeCategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/productAttribute/category")
public class ProductAttributeCategoryController {

    @Autowired
    private ProductAttributeService attributeService;

    @Autowired
    private ProductAttributeCategoryService productAttributeCategoryService;

    /**
     * 添加。
     *
     * @param productAttributeCategory 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody ProductAttributeCategory productAttributeCategory) {
        return productAttributeCategoryService.save(productAttributeCategory);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return productAttributeCategoryService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param productAttributeCategory 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody ProductAttributeCategory productAttributeCategory) {
        return productAttributeCategoryService.updateById(productAttributeCategory);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(productAttributeCategoryService.list());
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list/withAttr")
    public R listWithAttr() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<ProductAttributeCategory> list = productAttributeCategoryService.list();
        list.forEach(attrCate -> {
            queryWrapper.clear();
            queryWrapper.eq("product_attribute_category_id", attrCate.getId());
            attrCate.setProductAttributeList(attributeService.list(queryWrapper));
        });
        return R.ok(list);
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public ProductAttributeCategory getInfo(@PathVariable Long id) {
        return productAttributeCategoryService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<ProductAttributeCategory> page) {
        return R.ok(productAttributeCategoryService.page(page));
    }

}
