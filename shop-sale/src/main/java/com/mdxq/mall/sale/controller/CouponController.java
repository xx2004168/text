package com.mdxq.mall.sale.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.Coupon;
import com.mdxq.mall.sale.service.CouponService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 添加。
     *
     * @param coupon 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Coupon coupon) {
        return R.ok(couponService.save(coupon));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(couponService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param coupon 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody Coupon coupon) {
        return R.ok(couponService.updateById(coupon));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<Coupon> list() {
        return couponService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(couponService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Coupon> page, String name, Integer type) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        if (type != null) {
            queryWrapper.eq("type", type);
        }
        return R.ok(couponService.page(page, queryWrapper));
    }

}
