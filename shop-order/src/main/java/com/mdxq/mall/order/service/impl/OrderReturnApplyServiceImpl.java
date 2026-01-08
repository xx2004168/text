package com.mdxq.mall.order.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.mdxq.mall.order.client.ProductServiceClient;
import com.mdxq.mall.order.entity.OrderOperateHistory;
import com.mdxq.mall.order.mapper.OrderOperateHistoryMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.OrderReturnApply;
import com.mdxq.mall.order.mapper.OrderReturnApplyMapper;
import com.mdxq.mall.order.service.OrderReturnApplyService;
import io.seata.spring.annotation.GlobalTransactional;
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
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApply>  implements OrderReturnApplyService{

    @Autowired
    private OrderOperateHistoryMapper historyMapper;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    @Transactional
    public boolean removeByIds(List<String> ids, String token) {
        super.removeByIds(ids);
        for (String id : ids) {
            OrderOperateHistory history = new OrderOperateHistory();
            history.setOrderId(Long.valueOf(id));
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
    // 全家事务的注解（来自于seata框架）
    @GlobalTransactional
//    @Transactional// 这个注解生效范围仅仅是本地事务，他无法控制商品数据库的提交和回滚
    public boolean updateById(OrderReturnApply entity, boolean ignoreNulls) {
        if (entity.getStatus() == 2) {// 说明收到退货， 恢复库存
            OrderReturnApply apply = super.getById(entity.getId());// 查询退货详情
            productServiceClient.restocking(apply.getProductId(), apply.getProductCount());
        }
        return super.updateById(entity, ignoreNulls);
    }
}
