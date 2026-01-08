package com.mdxq.mall.sale.controller;

import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.FlashPromotion;
import com.mdxq.mall.sale.service.FlashPromotionService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/flash")
//@RequestMapping("/api/v1/flashPromotion")
public class FlashPromotionController {

    @Autowired
    private FlashPromotionService flashPromotionService;

    /**
     * 添加。
     *
     * @param flashPromotion 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody FlashPromotion flashPromotion) {
        return R.ok(flashPromotionService.save(flashPromotion));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(flashPromotionService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param flashPromotion 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@PathVariable Long id, @RequestBody FlashPromotion flashPromotion) {
        flashPromotion.setId(id);
        return R.ok(flashPromotionService.updateById(flashPromotion));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<FlashPromotion> list() {
        return flashPromotionService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public FlashPromotion getInfo(@PathVariable Long id) {
        return flashPromotionService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @param keyword 筛选关键词
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<FlashPromotion> page, String keyword) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("title", keyword);
        return R.ok(flashPromotionService.page(page, queryWrapper));
    }

    @PostMapping("update/status/{id}")
    public R updateStatus(@PathVariable Long id, @RequestParam int status) {
        FlashPromotion flashPromotion = flashPromotionService.getById(id);
        flashPromotion.setStatus(status);
        flashPromotionService.updateById(flashPromotion);
        return R.ok(true);
    }

}
