package com.mdxq.mall.order.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.mdxq.mall.order.entity.OrderOperateHistory;
import com.mdxq.mall.order.mapper.OrderOperateHistoryMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.OrderReturnReason;
import com.mdxq.mall.order.mapper.OrderReturnReasonMapper;
import com.mdxq.mall.order.service.OrderReturnReasonService;
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
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason>  implements OrderReturnReasonService{

    @Autowired
    private OrderOperateHistoryMapper historyMapper;

    @Override
    @Transactional
    public boolean updateStatus(Long ids, int status, String token) {
        OrderReturnReason orderReturnReason = super.getById(ids);
        orderReturnReason.setStatus(status);
        mapper.update(orderReturnReason, true);
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(orderReturnReason.getId());
        history.setCreateTime(LocalDateTime.now());
        history.setNote(String.format("修改了订单退回原因"));
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        historyMapper.insert(history);
        return true;
    }

    @Override
    @Transactional
    public boolean save(OrderReturnReason orderReturnReason, String token) {
        super.save(orderReturnReason);
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(orderReturnReason.getId());
        history.setCreateTime(LocalDateTime.now());
        history.setNote(String.format("添加了订单退回原因:%s", orderReturnReason.getName()));
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        historyMapper.insert(history);
        return true;
    }

    @Override
    @Transactional
    public boolean removeByIds(List<Long> ids, String token) {
        super.removeByIds(ids);
        for (Long id : ids) {
            OrderOperateHistory history = new OrderOperateHistory();
            history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
            history.setOrderId(id);
            history.setNote(String.format("删除了订单退回原因"));
            history.setCreateTime(LocalDateTime.now());
            historyMapper.insert(history);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateById(OrderReturnReason orderReturnReason, String token) {
        super.updateById(orderReturnReason,true);
        OrderOperateHistory history = new OrderOperateHistory();
        history.setOrderId(orderReturnReason.getId());
        history.setCreateTime(LocalDateTime.now());
        history.setNote("修改了订单退回原因");
        history.setOperateMan(JWTUtil.parseToken(token).getPayload("username").toString());
        historyMapper.insert(history);
        return true;
    }
}
