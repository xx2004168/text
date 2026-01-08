package com.mdxq.mall.sale.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.sale.dto.AdvertiseDTO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.HomeAdvertise;
import com.mdxq.mall.sale.service.HomeAdvertiseService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/home/advertise")
public class HomeAdvertiseController {

    @Autowired
    private HomeAdvertiseService homeAdvertiseService;

    /**
     * 添加。
     *
     * @param homeAdvertises
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody List<HomeAdvertise> homeAdvertises) {
        return R.ok(homeAdvertiseService.saveBatch(homeAdvertises));
    }

    /**
     * 根据主键删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam List<Long> ids) {
        return R.ok(homeAdvertiseService.removeByIds(ids));
    }

    /**
     * 根据主键更新。
     *
     * @param homeAdvertise 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody HomeAdvertise homeAdvertise) {
        return homeAdvertiseService.updateById(homeAdvertise);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<HomeAdvertise> list() {
        return homeAdvertiseService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(homeAdvertiseService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<HomeAdvertise> page, AdvertiseDTO dto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (dto.getType() != null) {
            queryWrapper.eq("type", dto.getType());
        }
        if (StrUtil.isNotBlank(dto.getName())) {
            queryWrapper.like("name", dto.getName());
        }
        if (dto.getEndTime() != null) {
            queryWrapper.eq("end_time", dto.getEndTime());

        }
        return R.ok(homeAdvertiseService.page(page, queryWrapper));
    }

    @PostMapping("update/status/{id}")
    public R updateStatus(@PathVariable Long id, @RequestParam int status) {
        HomeAdvertise advertise = homeAdvertiseService.getById(id);
        advertise.setStatus(status);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        homeAdvertiseService.update(advertise, queryWrapper);
        return R.ok(true);
    }

}
