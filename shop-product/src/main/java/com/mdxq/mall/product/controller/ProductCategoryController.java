package com.mdxq.mall.product.controller;

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
import com.mdxq.mall.product.entity.ProductCategory;
import com.mdxq.mall.product.service.ProductCategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 添加。
     *
     * @param productCategory 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody ProductCategory productCategory) {
        return R.ok(productCategoryService.save(productCategory));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return productCategoryService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param productCategory 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PostMapping("update/{id}")
    public R update(@PathVariable Long id, @RequestBody ProductCategory productCategory) {
        return R.ok(productCategoryService.updateById(productCategory));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping({"list"})
    public R list() {
        return R.ok(productCategoryService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(productCategoryService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page/{parentId}")
    public R page(Page<ProductCategory> page, @PathVariable Long parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", parentId);
        return R.ok(productCategoryService.page(page, queryWrapper));
    }


    /**
     * 查询所有的以及分类和子分类
     *
     * @return 所有数据
     */
    @GetMapping({"list/withChildren"})
    public R listWithChildren() {
        return R.ok(productCategoryService.listwithChildren());
    }
}
