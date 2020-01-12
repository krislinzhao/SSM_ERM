package club.krislin;

import club.krislin.dao.IMemberDao;
import club.krislin.dao.IProductDao;
import club.krislin.domain.Orders;
import club.krislin.service.IOrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin
 * @ClassName OrdersServiceTest
 * @Description TODO
 * @Date 20/1/6 15:58
 * @Author LIM
 * @Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
        "classpath*:spring-security.xml"})
public class OrdersServiceTest {
    @Resource
    private IOrdersService ordersService;
    @Resource
    private IMemberDao memberDao;

    @Test
    public void testOrderService() throws Exception {
        List<Orders> ordersList = ordersService.findAll(1,4);
        for (Orders order:ordersList){
            System.out.println(order);
        }
    }

    @Test
    public void testFindByOrdersId() throws Exception {
        Orders orders = ordersService.findById(1);
        System.out.println(orders);
        //Member member = memberDao.findById(1);
        //System.out.println(member);
    }

    @Resource
    private IProductDao productDao;

    @Test
    public void testDeleteOrder() throws Exception {
        productDao.deleteOrder(1);
    }
}
