package club.krislin.service.impl;

import club.krislin.dao.IOrdersDao;
import club.krislin.domain.Orders;
import club.krislin.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName OrdersServiceImpl
 * @Description TODO
 * @Date 20/1/6 15:09
 * @Author LIM
 * @Version V1.0
 */
@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {
    @Resource
    private IOrdersDao ordersDao;

    /**
     * 查询所有订单信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(Integer pageNum, Integer pageSize) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(pageNum,pageSize);
        return ordersDao.findAll();
    }

    /**
     * 通过id查询订单
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Orders findById(int id) throws Exception {
        return ordersDao.findById(id);
    }
}
