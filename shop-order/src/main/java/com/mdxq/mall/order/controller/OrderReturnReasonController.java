package com.mdxq.mall.order.controller;

import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.order.entity.OrderReturnReason;
import com.mdxq.mall.order.service.OrderReturnReasonService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/returnReason")
public class OrderReturnReasonController {

    @Autowired
    private OrderReturnReasonService orderReturnReasonService;

    /**
     * 添加。
     *
     * @param orderReturnReason 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody OrderReturnReason orderReturnReason, @RequestHeader("authorization") String token) {
        return R.ok(orderReturnReasonService.save(orderReturnReason, token));
    }

    /**
     * 根据主键删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam List<Long> ids, @RequestHeader("authorization") String token) {
        return R.ok(orderReturnReasonService.removeByIds(ids, token));
    }

    /**
     * 根据主键更新。
     *
     * @param orderReturnReason 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody OrderReturnReason orderReturnReason, @RequestHeader("authorization") String token) {
        return R.ok(orderReturnReasonService.updateById(orderReturnReason, token));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<OrderReturnReason> list() {
        return orderReturnReasonService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(orderReturnReasonService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<OrderReturnReason> page) {
        return R.ok(orderReturnReasonService.page(page));
    }

    @PostMapping("update/status")
    public R updateStatus(@RequestParam Long ids, @RequestParam int status, @RequestHeader("authorization") String token) {
        return R.ok(orderReturnReasonService.updateStatus(ids, status, token));
    }

}
