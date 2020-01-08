package club.krislin;

import club.krislin.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Package club.krislin
 * @ClassName ProductServiceTest
 * @Description TODO
 * @Date 20/1/5 17:57
 * @Author LIM
 * @Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProductServiceTest {
    @Autowired
    private IProductService productService;
    @Test
    public void testProductService() throws Exception {
        productService.findAll(1,5);
    }
}
