package com.mdxq.mall.sale.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.sale.entity.HomeRecommendProduct;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.sale.entity.HomeRecommendSubject;
import com.mdxq.mall.sale.service.HomeRecommendSubjectService;

import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/home/recommendSubject")
public class HomeRecommendSubjectController {

    @Autowired
    private HomeRecommendSubjectService homeRecommendSubjectService;

    /**
     * 添加。
     *
     * @param homeRecommendSubjects
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody List<HomeRecommendSubject> homeRecommendSubjects) {
        return R.ok(homeRecommendSubjectService.saveBatch(homeRecommendSubjects));
    }

    /**
     * 根据主键删除。
     *
     * @param ids 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam List<Long> ids) {
        return R.ok(homeRecommendSubjectService.removeByIds(ids));
    }

    /**
     * 根据主键更新。
     *
     * @param homeRecommendSubject 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody HomeRecommendSubject homeRecommendSubject) {
        return homeRecommendSubjectService.updateById(homeRecommendSubject);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<HomeRecommendSubject> list() {
        return homeRecommendSubjectService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public HomeRecommendSubject getInfo(@PathVariable Long id) {
        return homeRecommendSubjectService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<HomeRecommendSubject> page, String subjectName, Integer recommendStatus) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(subjectName)) {
            queryWrapper.like("subject_name", subjectName);
        }
        if (recommendStatus != null) {
            queryWrapper.eq("recommend_status", recommendStatus);
        }
        return R.ok(homeRecommendSubjectService.page(page, queryWrapper));
    }

    @PostMapping("update/recommendStatus")
    public R recommendStatus(@RequestParam List<Long> ids, int recommendStatus) {
        for (Long id : ids) {
            HomeRecommendSubject homeRecommendSubject = homeRecommendSubjectService.getById(id);
            homeRecommendSubject.setRecommendStatus(recommendStatus);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", id);
            homeRecommendSubjectService.update(homeRecommendSubject, queryWrapper);
        }
        return R.ok(true);
    }

    @PostMapping("update/sort/{id}")
    public R updateSort(@PathVariable Long id, @RequestParam int sort) {
        HomeRecommendSubject homeRecommendSubject = homeRecommendSubjectService.getById(id);
        homeRecommendSubject.setSort(sort);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return R.ok(homeRecommendSubjectService.update(homeRecommendSubject, queryWrapper));
    }

}
