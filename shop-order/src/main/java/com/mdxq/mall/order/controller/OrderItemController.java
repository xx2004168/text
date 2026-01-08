package com.mdxq.mall.order.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.order.entity.OrderItem;
import com.mdxq.mall.order.service.OrderItemService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    /**
     * 添加。
     *
     * @param orderItem 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return orderItemService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param orderItem 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody OrderItem orderItem) {
        return orderItemService.updateById(orderItem);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<OrderItem> list() {
        return orderItemService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public OrderItem getInfo(@PathVariable Long id) {
        return orderItemService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<OrderItem> page(Page<OrderItem> page) {
        return orderItemService.page(page);
    }

}
