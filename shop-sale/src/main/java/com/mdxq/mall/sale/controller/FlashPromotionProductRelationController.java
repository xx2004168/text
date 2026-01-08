package com.mdxq.mall.sale.controller;

import cn.hutool.core.bean.BeanUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.sale.client.ProductServiceClient;
import com.mdxq.mall.vo.ProductBaseInfoVo;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.FlashPromotionProductRelation;
import com.mdxq.mall.sale.service.FlashPromotionProductRelationService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/flashProductRelation")
public class FlashPromotionProductRelationController {

    @Autowired
    private FlashPromotionProductRelationService flashPromotionProductRelationService;

    /**
     * 添加。
     *
     * @param list
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody List<FlashPromotionProductRelation> list) {
        return R.ok(flashPromotionProductRelationService.saveBatch(list));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(flashPromotionProductRelationService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param flashPromotionProductRelation 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
        return R.ok(flashPromotionProductRelationService.updateById(flashPromotionProductRelation));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<FlashPromotionProductRelation> list() {
        return flashPromotionProductRelationService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public FlashPromotionProductRelation getInfo(@PathVariable Long id) {
        return flashPromotionProductRelationService.getById(id);
    }

    @Autowired
    private ProductServiceClient productServiceClient;

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<FlashPromotionProductRelation> page
            , @RequestParam Long flashPromotionId
            , @RequestParam Long flashPromotionSessionId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("flash_promotion_id", flashPromotionId);
        queryWrapper.eq("flash_promotion_session_id", flashPromotionSessionId);
        Page<FlashPromotionProductRelation> pageInfo = flashPromotionProductRelationService.page(page, queryWrapper);
        for (FlashPromotionProductRelation relation : pageInfo.getRecords()) {
            // 调用远程服务的基本信息
            Object object = productServiceClient.getBaseInfo(relation.getProductId()).getData();
            relation.setProduct(BeanUtil.copyProperties(object, ProductBaseInfoVo.class));
        }
        return R.ok(pageInfo);
    }

}
