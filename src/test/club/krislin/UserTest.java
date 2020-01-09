package club.krislin;

import club.krislin.dao.IUserDao;
import club.krislin.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Package club.krislin
 * @ClassName UserTest
 * @Description TODO
 * @Date 20/1/8 16:27
 * @Author LIM
 * @Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
        "classpath*:spring-security.xml"})
public class UserTest {
    @Autowired
    private IUserDao userDao;

    @Test
    public void testUser() throws Exception {
        UserInfo user = userDao.findByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void testFindById() throws Exception {
        UserInfo userInfo = userDao.findById(1);
        System.out.println(userInfo);
    }
}
