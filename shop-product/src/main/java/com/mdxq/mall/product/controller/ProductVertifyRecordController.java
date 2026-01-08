package com.mdxq.mall.product.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.product.entity.ProductVertifyRecord;
import com.mdxq.mall.product.service.ProductVertifyRecordService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/productVertifyRecord")
public class ProductVertifyRecordController {

    @Autowired
    private ProductVertifyRecordService productVertifyRecordService;

    /**
     * 添加。
     *
     * @param productVertifyRecord 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public boolean save(@RequestBody ProductVertifyRecord productVertifyRecord) {
        return productVertifyRecordService.save(productVertifyRecord);
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Long id) {
        return productVertifyRecordService.removeById(id);
    }

    /**
     * 根据主键更新。
     *
     * @param productVertifyRecord 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody ProductVertifyRecord productVertifyRecord) {
        return productVertifyRecordService.updateById(productVertifyRecord);
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<ProductVertifyRecord> list() {
        return productVertifyRecordService.list();
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public ProductVertifyRecord getInfo(@PathVariable Long id) {
        return productVertifyRecordService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<ProductVertifyRecord> page(Page<ProductVertifyRecord> page) {
        return productVertifyRecordService.page(page);
    }

}
