package com.mdxq.mall.sale.controller;

import cn.hutool.core.collection.CollUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.sale.service.FlashPromotionProductRelationService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.FlashPromotionSession;
import com.mdxq.mall.sale.service.FlashPromotionSessionService;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
//@RequestMapping("/api/v1/flashPromotionSession")
@RequestMapping("/api/v1/flashSession")
public class FlashPromotionSessionController {

    @Autowired
    private FlashPromotionSessionService flashPromotionSessionService;

    /**
     * 添加。
     *
     * @param flashPromotionSession 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody FlashPromotionSession flashPromotionSession) {
        return R.ok(flashPromotionSessionService.save(flashPromotionSession));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(flashPromotionSessionService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param flashPromotionSession 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody FlashPromotionSession flashPromotionSession) {
        return R.ok(flashPromotionSessionService.updateById(flashPromotionSession));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(flashPromotionSessionService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public FlashPromotionSession getInfo(@PathVariable Long id) {
        return flashPromotionSessionService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<FlashPromotionSession> page) {
        return R.ok(flashPromotionSessionService.page(page));
    }

    @PostMapping("update/status/{id}")
    public R updateStatus(@PathVariable Long id, @RequestParam int status) {
        FlashPromotionSession session = flashPromotionSessionService.getById(id);
        session.setStatus(status);
        flashPromotionSessionService.updateById(session);
        return R.ok(true);
    }

    @Autowired
    private FlashPromotionProductRelationService service;

    /**
     * 查询某个秒杀活动所有的时间段
     * @param flashPromotionId 秒杀活动ID
     * @return 所有数据
     */
    @GetMapping("selectList")
    public R fetchSelectList(@RequestParam Long flashPromotionId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("flash_promotion_id", flashPromotionId);
        queryWrapper.select("flash_promotion_session_id");
        // 查到时间段的id
        List<Long> sessionIds = service.listAs(queryWrapper, Long.class);
        if (CollUtil.isNotEmpty(sessionIds)) {
            return R.ok(flashPromotionSessionService.listByIds(sessionIds));
        } else {
            return R.ok(Collections.emptyList());
        }
    }

}
