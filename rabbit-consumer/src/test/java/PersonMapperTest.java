import com.mdxq.mall.RabbitConsumerAPP;
import com.mdxq.mall.entity.Person;
import com.mdxq.mall.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RabbitConsumerAPP.class)
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void t1() {
        Person person = personMapper.selectOneById(1);
        // 多次调用加了乐观锁的SQL，给松江的账号连续+4个500
        // 一次更新数据只能有一个成功，其他的都失败，正确的情况下最后账号余额应该为20500
        personMapper.updateBalance(500, person.getId(), person.getVersion());
        // 后边的3次，都会因为乐观锁无法成功
        personMapper.updateBalance(500, person.getId(), person.getVersion());
        personMapper.updateBalance(500, person.getId(), person.getVersion());
        personMapper.updateBalance(500, person.getId(), person.getVersion());
    }
}
