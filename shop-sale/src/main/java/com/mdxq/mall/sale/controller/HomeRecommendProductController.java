package com.mdxq.mall.sale.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.HomeRecommendProduct;
import com.mdxq.mall.sale.service.HomeRecommendProductService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/home/recommendProduct")
public class HomeRecommendProductController {

    @Autowired
    private HomeRecommendProductService homeRecommendProductService;

    /**
     * 添加。
     *
     * @param homeRecommendProducts
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody List<HomeRecommendProduct> homeRecommendProducts) {
        return R.ok(homeRecommendProductService.saveBatch(homeRecommendProducts));
    }

    /**
     * 根据主键删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam List<Long> ids) {
        return R.ok(homeRecommendProductService.removeByIds(ids));
    }

    /**
     * 根据主键更新。
     *
     * @param homeRecommendProduct 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        return homeRecommendProductService.updateById(homeRecommendProduct);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<HomeRecommendProduct> list() {
        return homeRecommendProductService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public HomeRecommendProduct getInfo(@PathVariable Long id) {
        return homeRecommendProductService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<HomeRecommendProduct> page, String productName, Integer recommendStatus) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(productName)) {
            queryWrapper.like("product_name", productName);
        }
        if (recommendStatus != null) {
            queryWrapper.eq("recommend_status", recommendStatus);
        }
        return R.ok(homeRecommendProductService.page(page,queryWrapper));
    }

    @PostMapping("update/recommendStatus")
    public R recommendStatus(@RequestParam List<Long> ids, int recommendStatus) {
        for (Long id : ids) {
            HomeRecommendProduct homeRecommendProduct = homeRecommendProductService.getById(id);
            homeRecommendProduct.setRecommendStatus(recommendStatus);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            homeRecommendProductService.update(homeRecommendProduct, queryWrapper);
        }
        return R.ok(true);
    }

    @PostMapping("update/sort/{id}")
    public R updateSort(@PathVariable Long id, @RequestParam int sort) {
        HomeRecommendProduct homeRecommendProduct = homeRecommendProductService.getById(id);
        homeRecommendProduct.setSort(sort);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return R.ok(homeRecommendProductService.update(homeRecommendProduct, queryWrapper));
    }


}
