package mapper;

import com.mdxq.mall.user.UserApp;
import com.mdxq.mall.user.entity.Employee;
import com.mdxq.mall.user.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = UserApp.class)
public class MybatisFlexMapperTest {
    @Autowired
    EmployeeMapper mapper;

    @Test
    public void t1() {
        Employee e1 = mapper.selectOneById(1);
        System.out.println(e1);
    }
}
