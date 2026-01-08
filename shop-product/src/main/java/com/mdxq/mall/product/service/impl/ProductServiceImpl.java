package com.mdxq.mall.product.service.impl;

import com.mdxq.mall.product.entity.*;
import com.mdxq.mall.product.mapper.*;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

import static cn.hutool.json.XMLTokener.entity;
import static com.mdxq.mall.product.entity.table.ProductTableDef.PRODUCT;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>  implements ProductService{

    @Autowired
    private AlbumMapper albumMapper;// 商品图册 mapper

    @Autowired
    private AlbumPicMapper albumPicMapper;// 商品图册图片 mapper

    @Autowired
    private ProductAttributeValueMapper attributeValueMapper;// 属性值 mapper

    @Autowired
    private SkuStockMapper skuStockMapper;// sku库存 mapper

    @Override
    @Transactional
    public boolean save(Product product) {
        // 1.保存商品相册和图片
        // 保存商品图册
        Album album = new Album();
        album.setName(product.getName());// 相册名称和商品名称一致
        album.setCoverPic(product.getPic());// 相册封面和商品封面一致
        String[] albumPics = product.getAlbumPics().split(",");
        album.setPicCount(albumPics.length);
        albumMapper.insert(album);// 保存商品图册
        // 在保存商品图册中的图片
        for (String url : albumPics) {
            AlbumPic albumPic = new AlbumPic(null, album.getId(), url);
            albumPicMapper.insert(albumPic);// 保存图册中的图片
        }
        // 2.保存商品信息,数据库会将生成的商品id返回到实例中
        mapper.insert(product);
        // 3.保存商品的属性值
        for (ProductAttributeValue attributeValue : product.getProductAttributeValueList()) {
            attributeValue.setProductId(product.getId());// 注入商品id
            attributeValueMapper.insert(attributeValue);
        }
        // 4.保存sku库存
        for (SkuStock skuStock : product.getSkuStockList()) {
            skuStock.setProductId(product.getId());
            skuStockMapper.insert(skuStock);
        }
        return true;
    }

    @Override
    public Product getById(Serializable id) {
        Product product = super.getById(id);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id", id);// 使用商品id作为条件
        // 查询商品的属性值列表
        product.setProductAttributeValueList(attributeValueMapper.selectListByQuery(queryWrapper));
        queryWrapper.clear();
        queryWrapper.eq("product_id", id);// 使用商品id作为条件
        // 查询商品的sku库存列表
        product.setSkuStockList(skuStockMapper.selectListByQuery(queryWrapper));
        return product;
    }

    @Override
    @Transactional
    public boolean updateById(Product product) {
        // 1.保存商品相册和图片
        // 保存商品图册
        Album album = new Album();
        album.setName(product.getName());// 相册名称和商品名称一致
        album.setCoverPic(product.getPic());// 相册封面和商品封面一致
        String[] albumPics = product.getAlbumPics().split(",");
        album.setPicCount(albumPics.length);
        albumMapper.insert(album);// 保存商品图册
        // 在保存商品图册中的图片
        for (String url : albumPics) {
            AlbumPic albumPic = new AlbumPic(null, album.getId(), url);
            albumPicMapper.insert(albumPic);// 保存图册中的图片
        }
        // 2.保存商品信息,数据库会将生成的商品id返回到实例中
        mapper.update(product);
        // 3.保存商品的属性值
        // 先把当前商品关联的数据给清空
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id", product.getId());
        attributeValueMapper.deleteByQuery(queryWrapper);
        for (ProductAttributeValue attributeValue : product.getProductAttributeValueList()) {
            attributeValue.setProductId(product.getId());// 注入商品id
            attributeValueMapper.insert(attributeValue);
        }
        // 4.保存sku库存
        queryWrapper.clear();
        queryWrapper.eq("product_id", product.getId());
        skuStockMapper.deleteByQuery(queryWrapper);
        for (SkuStock skuStock : product.getSkuStockList()) {
            skuStock.setProductId(product.getId());
            skuStockMapper.insert(skuStock);
        }
        return true;
    }

    @Override
    public boolean updateStock(Long id, Integer num) {
        // 利用UpdateEntity创建一个商品实例，并指定ID
        Product product = UpdateEntity.of(Product.class, id);
        UpdateWrapper<Product> updateWrapper = UpdateWrapper.of(product);
        // 后边两种写法二选一
        updateWrapper.set(PRODUCT.STOCK, PRODUCT.STOCK.add(num));
//        updateWrapper.setRaw("stock", "stock + " + num);
        return mapper.update(product) > 0;
    }
}
