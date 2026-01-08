package com.mdxq.mall.sale.controller;

import cn.hutool.core.util.StrUtil;
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
import com.mdxq.mall.sale.entity.CouponHistory;
import com.mdxq.mall.sale.service.CouponHistoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/couponHistory")
public class CouponHistoryController {

    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 添加。
     *
     * @param couponHistory 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody CouponHistory couponHistory) {
        return R.ok(couponHistoryService.save(couponHistory));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(couponHistoryService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param couponHistory 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody CouponHistory couponHistory) {
        return R.ok(couponHistoryService.updateById(couponHistory));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<CouponHistory> list() {
        return couponHistoryService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public CouponHistory getInfo(@PathVariable Long id) {
        return couponHistoryService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<CouponHistory> page, Integer useStatus, String orderSn) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(orderSn)) {
            queryWrapper.eq("order_sn", orderSn);
        } else {
            if (useStatus != null) {
                queryWrapper.eq("use_status", useStatus);
            }
        }
        return R.ok(couponHistoryService.page(page, queryWrapper));
    }

}
