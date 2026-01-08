package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.Brand;
import com.mdxq.mall.product.mapper.BrandMapper;
import com.mdxq.mall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
@Slf4j
// 放在类之前，提供当前类下所有方法统一的缓存设置
@CacheConfig(cacheNames = "brandCache", cacheManager = "cacheManager")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>  implements BrandService{
    @Override
    // 将当前方法返回的对象（结果）存到缓存里：这俩个注解任选其一
    // @Cacheable先判断缓存里有没有，如果有就不执行方法，直接从缓存里取：如果没有执行方法，将返回值存入数据库
//    @Cacheable(value = "brandCache", key = "#id")
    // @CachePut无论缓存里有没有，都执行这个方法，然后将执行结果放入缓存
//    @CachePut(value = "brandCache", key = "#id")
    @CachePut(key = "#id")
    public Brand getById(Serializable id) {
        log.info("从MySQL中查到了这个记录！");
        return super.getById(id);
    }

    @Override
    // 当执行到这个方法时，将缓存中对重的键清除掉，保证了数据发生修改（删除）后清理掉相关的缓存，这样客户端查到的永远是最新的数据
//    @CacheEvict(value = "brandCache", key = "#entity.id")
    // 将该缓存名下的所有key都清理掉
//    @CacheEvict(value = "brandCache", allEntries = true)
    @CacheEvict(allEntries = true)
    public boolean updateById(Brand entity) {
        return super.updateById(entity);
    }

    @Override
//    @CacheEvict(value = "brandCache", key = "#id")
    @CacheEvict(key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
//    @Cacheable(value = "brandCache", key = "'list'")
    @Cacheable(key = "'list'")
    public List<Brand> list() {
        return super.list();
    }
}
