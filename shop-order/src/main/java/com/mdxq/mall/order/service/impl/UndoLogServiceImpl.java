package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.UndoLog;
import com.mdxq.mall.order.mapper.UndoLogMapper;
import com.mdxq.mall.order.service.UndoLogService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-08-11
 */
@Service
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLog>  implements UndoLogService{

}
