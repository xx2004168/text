package com.mdxq.mall.product.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.product.dto.ProductSearchDTO;
import com.mdxq.mall.response.R;
import com.mdxq.mall.vo.ProductBaseInfoVo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.product.entity.Product;
import com.mdxq.mall.product.service.ProductService;

import java.util.Arrays;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加。
     *
     * @param product 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Product product) {
        return R.ok(productService.save(product));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(productService.removeById(id));
    }
    /**
     * 根据主键删除。
     *
     * @param deleteStatus
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("update/deleteStatus")
    public R updateDeleteStatus(@RequestParam String ids, @RequestParam Integer deleteStatus) {

       QueryWrapper queryWrapper = new QueryWrapper();
       queryWrapper.in("id", ids.split(","));
       List<Product> list = productService.list(queryWrapper);
       for (Product product : list) {
           product.setDeleteStatus(deleteStatus);
       }
       // 批量更新多个商品的删除状态（复活）
       return R.ok(productService.updateBatch(list, true));


    }

    /**
     * 根据主键更新。
     *
     * @param product 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PostMapping("update")
    public R update(@RequestBody Product product) {
        return R.ok(productService.updateById(product));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<Product> list() {
        return productService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(productService.getById(id));
    }

    /**
     * 根据主键获取基本信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getBaseInfo/{id}")
    public R getBaseInfo(@PathVariable Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        queryWrapper.select("id", "name", "product_sn", "price", "stock");
        return R.ok(productService.getOneAs(queryWrapper, ProductBaseInfoVo.class));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Product> page, ProductSearchDTO dto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (dto.getProductSn() != null) {
            queryWrapper.eq("product_sn", dto.getProductSn());
        }
        else {
            if (StrUtil.isNotBlank(dto.getKeyword())) {
                queryWrapper.like("name", dto.getKeyword());
            }
            if (dto.getProductCategoryId() != null) {
                queryWrapper.eq("product_category_id", dto.getProductCategoryId());
            }
            if (dto.getBrandId() != null) {
                queryWrapper.eq("brand_id", dto.getBrandId());
            }
            if (dto.getVerifyStatus() != null) {
                queryWrapper.eq("verify_status", dto.getVerifyStatus());
            }
            if (dto.getPublishStatus() != null) {
                queryWrapper.eq("publish_status", dto.getPublishStatus());
            }
        }

        return R.ok(productService.page(page,queryWrapper));
    }

    @GetMapping("simpleList")
    public R simpleList(String keyword) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", keyword);
        return R.ok(productService.list(queryWrapper));
    }

    /**
     * 买家退货后恢复商品的库存（退货的商品重新入库）
     * @param pid 商品ID
     * @param num 退货数量
     * @return
     */
    @PostMapping("restocking")
    public R restocking(@RequestParam Long pid, @RequestParam Integer num) {
        // 调用写好的service方法，更新库存
        return R.ok(productService.updateStock(pid, num));
    }

}
