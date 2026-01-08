package com.mdxq.mall.order.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.mdxq.mall.order.dto.UpdateDeliveryDTO;
import com.mdxq.mall.order.dto.UpdateNodeDTO;
import com.mdxq.mall.order.entity.OrderOperateHistory;
import com.mdxq.mall.order.mapper.OrderOperateHistoryMapper;
import com.mybatisflex.core.util.UpdateEntity;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.Order;
import com.mdxq.mall.order.mapper.OrderMapper;
import com.mdxq.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>  implements OrderService{

    @Autowired
    private OrderOperateHistoryMapper historyMapper;

    @Override
    @Transactional
    public boolean updateReceiverInfo(Order order, String token) {
        // 先更新订单表
        mapper.update(order, true);// 更新订单表，同时忽略订单对象中的null属性
        // 再新增管理员操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(order.getId());
        history.setOrderStatus(order.getStatus());
        history.setCreateTime(LocalDateTime.now());
        history.setNote("修改了订单的收件人信息");
        // 从token令牌中解析出操作人的用户名
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        historyMapper.insert(history);// 新增一条更新订单的历史记录
        return true;
    }

    @Override
    @Transactional
    public boolean updateNote(UpdateNodeDTO dto, String token) {
        Order order = UpdateEntity.of(Order.class, dto.getId());
        order.setNote(dto.getNote());// 修改备注
        mapper.update(order, true);
//        order.setStatus(dto.getStatus());
        // 再新增管理员操作记录
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(order.getId());
        history.setOrderStatus(dto.getStatus());
        history.setCreateTime(LocalDateTime.now());
        history.setNote(String.format("修改了订单的备注内容: %s~", dto.getNote()));
        // 从token令牌中解析出操作人的用户名
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        historyMapper.insert(history);// 新增一条更新订单的历史记录
        return true;
    }

    @Override
    @Transactional
    public boolean updateDelivery(List<UpdateDeliveryDTO> dtoList, String token) {
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderStatus(2);
        history.setCreateTime(LocalDateTime.now());
        history.setNote("订单发货~");
        // 从token令牌中解析出操作人的用户名
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        for (UpdateDeliveryDTO dto : dtoList) {
            Order order = UpdateEntity.of(Order.class, dto.getOrderId());
            order.setStatus(2);// 修改状态
            order.setDeliveryCompany(dto.getDeliveryCompany());// 修改物流公司
            order.setDeliverySn(dto.getDeliverySn());// 修改快递单号
            mapper.update(order,true);
            history.setOrderId(order.getId());
            historyMapper.insert(history);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean removeByIds(List<String> idList, String token) {
        super.removeByIds(idList);// 批量删除订单
        for (String orderId : idList) {
            OrderOperateHistory history = new OrderOperateHistory();
            history.setOrderId(Long.valueOf(orderId));
            history.setOrderStatus(5);
            history.setCreateTime(LocalDateTime.now());
            history.setNote("删除订单~");
            // 从token令牌中解析出操作人的用户名
            history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
            historyMapper.insert(history);// 新增一条更新订单的历史记录
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateClose(List<Long> ids, String note, String token) {
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderStatus(4);
        // 从token令牌中解析出操作人的用户名
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        for (Long id : ids) {
            Order order = mapper.selectOneById(id);
            order.setStatus(4);// 修改状态
            order.setNote(note);// 修改物流公司
            mapper.update(order,true);
            history.setOrderId(order.getId());
            history.setNote(String.format("修改了订单的备注内容: %s~", note));
            historyMapper.insert(history);
        }
        return true;
    }
}
