package com.mdxq.mall.order.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.order.dto.*;
import com.mdxq.mall.order.service.OrderItemService;
import com.mdxq.mall.order.service.OrderOperateHistoryService;
import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.order.entity.Order;
import com.mdxq.mall.order.service.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加。
     *
     * @param order 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody Order order) {
        return orderService.save(order);
    }

    /**
     * 根据主键批量删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @PostMapping("delete")
    public R remove(@RequestParam String ids, @RequestHeader("authorization") String token) {
        // 1.先将多个id分割成多个数组2.将数组转为集合3.执行批量删除
        return R.ok(orderService.removeByIds(Arrays.asList(ids.split(",")), token));
    }

    /**
     * 根据主键更新。
     *
     * @param order 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody Order order) {
        return orderService.updateById(order);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<Order> list() {
        return orderService.list();
    }

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderOperateHistoryService historyService;

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order != null) {
            QueryWrapper queryWrapper = QueryWrapper.create().eq("order_id", id);
            order.setOrderItemList(orderItemService.list(queryWrapper));
            queryWrapper.clear();
            queryWrapper.eq("order_id", id);
            order.setHistoryList(historyService.list(queryWrapper));
        }

        return R.ok(order);
    }

    // 这个模式对象可以用来判断一个字符串是不是手机号
    private Pattern pattern = Pattern.compile("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$");

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @param dto 封装查询条件
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Order> page, OrderSearchDTO dto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(dto.getOrderSn())) {// 若订单编号不为空，则忽略其他条件
            queryWrapper.eq("order_sn", dto.getOrderSn());
        } else {
            if (StrUtil.isNotBlank(dto.getReceiverKeyword())) {
                // 如果 ReceiveKeyword 是手机号，则matches方法返回true，否则返回false
                if(pattern.matcher(dto.getReceiverKeyword()).matches()) {
                    queryWrapper.eq("receiver_phone", dto.getReceiverKeyword());
                } else {
                    queryWrapper.eq("receiver_name", dto.getReceiverKeyword());
                }
            }
            if(dto.getStatus() != null) {
                queryWrapper.eq("status", dto.getStatus());
            }
            if(dto.getOrderType() != null) {
                queryWrapper.eq("order_type", dto.getOrderType());
            }
            if(dto.getSourceType() != null) {
                queryWrapper.eq("source_type", dto.getSourceType());
            }
            if(dto.getCreateTime() != null) {
                queryWrapper.between("create_time"
                        // 2025-01-20 00:00:00
                        , LocalDateTime.of(dto.getCreateTime(), LocalTime.MIN)
                        // 2025-01-20 23:59:59
                        , LocalDateTime.of(dto.getCreateTime(), LocalTime.MAX));
            }

        }
        return R.ok(orderService.page(page, queryWrapper));
    }

    @PostMapping("update/receiverInfo")
    public R updateReceiverInfo(@RequestBody UpdateReceiverInfoDTO dto, @RequestHeader("authorization") String token) {
        // 先将dto转成Order
        Order order = BeanUtil.copyProperties(dto, Order.class);
        order.setId(dto.getOrderId());// 订单ID需要单独额外赋值
        boolean f = orderService.updateReceiverInfo(order, token);
        return R.ok(f);
    }

    @PostMapping("update/note")
    public R updateNote(UpdateNodeDTO dto, @RequestHeader("authorization") String token) {
        boolean f = orderService.updateNote(dto, token);
        return R.ok(f);
    }

    @PostMapping("update/delivery")
    public R updateDelivery(@RequestBody List<UpdateDeliveryDTO> dtoList, @RequestHeader("authorization") String token) {
        boolean f = orderService.updateDelivery(dtoList, token);
        return R.ok(f);
    }

    @PostMapping("update/close")
    public R updateClose(@RequestParam List<Long> ids, @RequestParam String note, @RequestHeader("authorization") String token) {
        boolean f = orderService.updateClose(ids, note, token);
        return R.ok(f);
    }

}
