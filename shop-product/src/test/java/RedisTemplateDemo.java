import cn.hutool.core.collection.CollUtil;
import com.mdxq.mall.product.ProductApp;
import com.mdxq.mall.product.entity.Brand;
import com.mdxq.mall.product.mapper.BrandMapper;
import com.mdxq.mall.product.mapper.ProductMapper;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = ProductApp.class)
@Slf4j
public class RedisTemplateDemo {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    BrandMapper brandMapper;

    // 将一个品牌对象缓存到redis
    @Test
    public void t1() {
        Brand brand = brandMapper.selectOneById(3);// 华为品牌
        // 返回操作String类型的Operations对象
        ValueOperations<String, Brand> operations = redisTemplate.opsForValue();
        operations.set("brand:3", brand);// 经过Java对象的序列化，默认选择的格式是二进制
        // 这个Key将在5分钟后过期
        redisTemplate.expire("brand:3", 15, TimeUnit.MINUTES);
        log.info("操作成功！");
    }

    // 查询上一步缓存的Redis中的华为品牌信息
    @Test
    public void t2() {
        // 返回操作String类型的Operations对象
        ValueOperations<String, Brand> operations = redisTemplate.opsForValue();
        Brand brand = operations.get("brand:3");// 将查到的结果反序列化成一个Jav实例
        log.info("查询到品牌信息：{}", brand);
    }

    // 使用RedisTemplate操作List数据类型
    @Test
    public void t3() {
        // 从MySQL中查询全部的品牌列表，然后保存到Redis中
        List<Brand> brandList = brandMapper.selectAll();
        // 返回一个可以操作Redis的List类型数据
        ListOperations<String, Brand> listOperations = redisTemplate.opsForList();
        String key = "allBrandList";
        if (redisTemplate.hasKey(key)) {
            // 如果这个key已经存在了，就先删除
            redisTemplate.delete(key);
        }
        // 将整个品牌列表全部push到Redis的列表里,返回push成功后列表的最终长度
        long llen = listOperations.rightPushAll(key, brandList);
        if (llen > 0) {
            log.info("品牌列表已缓存到Redis~");
        }
    }

    @Test
    public void t4() {
        // 先到缓存中查找数据（品牌列表），如果缓存中找到了直接输出，如果缓存中未找到则查询MySQL数据库，并将查询到的结果存到缓存中
        ListOperations<String, Brand> listOperations = redisTemplate.opsForList();
        List<Brand> brandList = null;
        String key = "allBrandList";
        if (redisTemplate.hasKey(key)) {
            log.info("从Redis缓存中查到缓存列表，如下：");
            // 从缓存中获取到结果
            brandList = listOperations.range(key, 0, -1);
        } else {
            brandList = brandMapper.selectAll();
            log.info("从MySQL数据库中查到品牌列表并加入Redis缓存！");
            listOperations.rightPushAll(key, brandList);
        }
        if (CollUtil.isNotEmpty(brandList)) {
            brandList.forEach(System.out::println);
        }
    }

    // 操作Set
    @Test
    public void t5() {
        // SetOperations 用来操作Redis 的 set类型数据
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String k1 = "fruitSet1", k2 = "fruitSet2";
        setOperations.add(k1, "苹果", "橘子", "鸭梨");
        setOperations.add(k2, "香蕉", "橘子", "葡萄", "火龙果");
        // 分别计算两个”果篮“的交(inter)并(union)差(different)集
        log.info("两个果篮的交集是：");
        setOperations.intersect(k1,k2).forEach(System.out::println);
        log.info("两个果篮的并集是：");
        setOperations.union(k1,k2).forEach(System.out::println);
        log.info("两个果篮的差集是：");
        setOperations.difference(k1,k2).forEach(System.out::println);

    }

    // 操作ZSet
    @Test
    public void t6() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        String key = "当日蔬菜水果价格_ZSet";
        zSetOperations.add(key, "阿克苏苹果", 5.99);
        zSetOperations.add(key, "香蕉", 4.99);
        zSetOperations.add(key, "晴王葡萄", 10.99);
        zSetOperations.add(key, "柑橘", 3.99);
        zSetOperations.add(key, "99草莓", 15.99);
        zSetOperations.add(key, "鸭梨", 6.99);
        // 只有Element，没有score
        Set<Object> members = zSetOperations.range(key, 0, -1);
        // 返回元组（Element和Score）集
        //        Set<ZSetOperations.TypedTuple<Object>> tupleSet = zSetOperations.rangeWithScores(key, 0, -1);
        // 按照score由高到低返回
//        Set<ZSetOperations.TypedTuple<Object>> tupleSet = zSetOperations.reverseRangeByScoreWithScores(key, 0, -1);
        // 查询指定价格返回
        Set<ZSetOperations.TypedTuple<Object>> tupleSet = zSetOperations.reverseRangeByScoreWithScores(key, 5.0, 100, 0, -1);
        tupleSet.forEach(tuple -> {
            log.info("水果：{}，价格：{}", tuple.getValue(), tuple.getScore());
        });
    }

    @Autowired
    ProductMapper productMapper;

    // 操作Hash
    @Test
    public void t7() {
        // 如果想要保存一个对象（一条数据库记录）的部分数据，可与选择Hash来保存，或者保存跨多张表的部分查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id", "name", "product_sn", "price", "brand_name");
        queryWrapper.eq("id", 38);// 查询38号商品
        // 返回38号商品的部分数据，存到一个HashMap对象中
        Map<String, Object> productInfo = productMapper.selectOneByQueryAs(queryWrapper, HashMap.class);
        BigDecimal priceDecimal = (BigDecimal) productInfo.get("price");
        productInfo.remove("price");
        productInfo.put("price", priceDecimal.floatValue());// 保存数据前先将价格的格式改为float类型（默认：BigDecimal）
        // 三个泛型分别是：Redis的key类型， Field类型，Value类型
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        String key = "Product:38";
        redisTemplate.delete(key);// 先把之前的数据从缓存中删除
        hashOperations.putAll(key, productInfo);
        log.info("操作成功：用Hash类型保存商品的部分数据到Redis");
    }

    @Test
    public void t8() {
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        String key = "Product:38";
        float oldPrice = (float) hashOperations.get(key, "price");
        float newPrice = oldPrice + 100f;
        log.info("加价之前的价格：{}", hashOperations.get(key, "price"));
        hashOperations.put(key, "price", newPrice);
//        hashOperations.increment(key, "price", 100f);
        log.info("加价之后的价格：{}", hashOperations.get(key, "price"));
        log.info("一共查询到{}个键值对", hashOperations.size(key));
        Map<String, Object> productInfo = hashOperations.entries(key);
        productInfo.forEach((k,v) -> {
            log.info("Field:{},Value:{}", k, v);
        });
    }



}
