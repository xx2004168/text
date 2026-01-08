package com.mdxq.mall.mapper;

import com.mdxq.mall.entity.Person;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    // 乐观锁的第二步，在更新语句中额外增加一个version=？做条件， 同时set子句给version+1
    @Update("update mq_person set account_balance = account_balance + #{param1}, version = version + 1" +
            " where id = #{param2} and version = #{param3}")
    int updateBalance(float money, int id, int version);
}
