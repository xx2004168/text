package com.mdxq.mall.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.mdxq.mall.product.entity.ProductCategoryAttributeRelation;
import com.mdxq.mall.product.mapper.ProductCategoryAttributeRelationMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.ProductCategory;
import com.mdxq.mall.product.mapper.ProductCategoryMapper;
import com.mdxq.mall.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory>  implements ProductCategoryService{

    // 装配一个商品类别-属性关联的mapper
   @Autowired
   private ProductCategoryAttributeRelationMapper attributeRelationMapper;

    @Override
    public List<ProductCategory> listwithChildren() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id", "name");
        // 设置一级分类的查询条件
        queryWrapper.eq("level", 0);
        // 消除掉无需显示的分类
        queryWrapper.eq("show_status", 1);
        List<ProductCategory> list = mapper.selectListByQuery(queryWrapper);
        for (ProductCategory productCategory : list) {
            // 将之前的查询条件清空
            queryWrapper.clear();
            queryWrapper.select("id", "name","parent_id");
            queryWrapper.eq("parent_id", productCategory.getId());
            queryWrapper.eq("show_status", 1);
            productCategory.setChildren(mapper.selectListByQuery(queryWrapper));
        }
        return list;
    }

    // 重写商品类别的save方法
    @Override
    @Transactional
    public boolean save(ProductCategory entity) {
        // 如果parentId是0说明是一级属性 否则是 二级属性
        entity.setLevel(entity.getParentId() == 0 ? 0 : 1);
        entity.setProductCount(0);// 初始化商品数量
        boolean ret = super.save(entity);
        // 如果商品类别添加成功 && 关联的属性ID列表不为空
        if (ret && CollUtil.isNotEmpty(entity.getProductAttributeIdList())) {
            // 添加关联表的数据
            List<ProductCategoryAttributeRelation> relationList = new ArrayList<>();
            entity.getProductAttributeIdList().forEach(attrId -> {
                // 封装relation实例，添加列表里
                relationList.add(new ProductCategoryAttributeRelation(null, entity.getId(), attrId));
            });
            // 批量添加关联记录
            attributeRelationMapper.insertBatch(relationList);
        }
        return ret;
    }

    @Override
    @Transactional
    public boolean updateById(ProductCategory entity) {
        // 如果parentId是0说明是一级属性 否则是 二级属性
        entity.setLevel(entity.getParentId() == 0 ? 0 : 1);
        boolean ret = super.updateById(entity);
        if (ret) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("product_category_id", entity.getId());
            // 先将关联表中和当前类别有关的记录删除
            attributeRelationMapper.deleteByQuery(queryWrapper);
            // 如果关联的商品属性ID列表不为空，就把关联的巨鹿添加进去
            if (CollUtil.isNotEmpty(entity.getProductAttributeIdList())) {
                // 添加关联表的数据
                List<ProductCategoryAttributeRelation> relationList = new ArrayList<>();
                entity.getProductAttributeIdList().forEach(attrId -> {
                    // 封装relation实例，添加列表里
                    relationList.add(new ProductCategoryAttributeRelation(null, entity.getId(), attrId));
                });
                // 批量添加关联记录
                attributeRelationMapper.insertBatch(relationList);
            }
        }
        return ret;
    }
}
