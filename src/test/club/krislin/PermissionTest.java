package club.krislin;

import club.krislin.dao.IPermissionDao;
import club.krislin.domain.Permission;
import club.krislin.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Package club.krislin
 * @ClassName PermissionTest
 * @Description TODO
 * @Date 20/1/9 15:29
 * @Author LIM
 * @Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
        "classpath*:spring-security.xml"})
public class PermissionTest {
    @Autowired
    private IPermissionDao permissionDao;
    @Autowired
    private IPermissionService permissionService;

    @Test
    public void testFindAll() throws Exception {
        //List<Permission> permissions = permissionDao.findAll();
        //System.out.println(permissions);
        List<Permission> all = permissionService.findAll(1, 5);
        System.out.println(all);
    }
}
