package com.mdxq.mall.order.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.order.dto.ReturnApplyInfoDTO;
import com.mdxq.mall.order.dto.ReturnApplySearchDTO;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.order.entity.OrderReturnApply;
import com.mdxq.mall.order.service.OrderReturnApplyService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/returnApply")
public class OrderReturnApplyController {

    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 添加。
     *
     * @param orderReturnApply 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody OrderReturnApply orderReturnApply) {
        return orderReturnApplyService.save(orderReturnApply);
    }

    /**
     * 根据主键删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam String ids, @RequestHeader("authorization") String token) {
        return R.ok(orderReturnApplyService.removeByIds(Arrays.asList(ids.split(",")), token));
    }

    /**
     * 根据主键更新。
     *
     * @param orderReturnApply 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody OrderReturnApply orderReturnApply) {
        return orderReturnApplyService.updateById(orderReturnApply);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(orderReturnApplyService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(orderReturnApplyService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<OrderReturnApply> page, ReturnApplySearchDTO dto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (dto.getId() != null) {
            queryWrapper.eq("id", dto.getId());
        }
        if (dto.getStatus() != null) {
            queryWrapper.eq("status", dto.getStatus());
        }
        if (StrUtil.isNotBlank(dto.getHandleMan())) {
            queryWrapper.eq("handle_man", dto.getHandleMan());
        }
        if(dto.getCreateTime() != null) {
            queryWrapper.between("create_time"
                    // 2025-01-20 00:00:00
                    , LocalDateTime.of(dto.getCreateTime(), LocalTime.MIN)
                    // 2025-01-20 23:59:59
                    , LocalDateTime.of(dto.getCreateTime(), LocalTime.MAX));
        }
        if (dto.getHandleTime() != null) {
            queryWrapper.between("handle_time",
                    LocalDateTime.of(dto.getHandleTime(), LocalTime.MIN),
                    LocalDateTime.of(dto.getHandleTime(), LocalTime.MAX));
        }
        return R.ok(orderReturnApplyService.page(page, queryWrapper));
    }

    /**
     * 退货处理1.确认退货2.拒绝退货3.确认收到退货
     * @param dto 封装退货处理的部分数据
     * @param id 退货处理ID
     * @return
     */
    @PostMapping("update/status/{id}")
    public R updateStatus(@RequestBody ReturnApplyInfoDTO dto, @PathVariable Long id) {
        // 将dto对象中的属性复制到一个订单退货处理的实例中
        OrderReturnApply orderReturnApply = BeanUtil.copyProperties(dto, OrderReturnApply.class);
        orderReturnApply.setId(id);
        orderReturnApply.setHandleTime(LocalDateTime.now());
        // 更新退货处理表
        return R.ok(orderReturnApplyService.updateById(orderReturnApply, true));
    }

}
