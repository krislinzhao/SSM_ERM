package club.krislin.service;

import club.krislin.domain.Orders;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName IOrdersService
 * @Description TODO
 * @Date 20/1/6 15:09
 * @Author LIM
 * @Version V1.0
 */
public interface IOrdersService {
    /**
     * 查询所有订单信息
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Orders> findAll(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 通过id查询订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findById(int ordersId) throws Exception;
}
