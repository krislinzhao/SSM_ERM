package club.krislin.dao;

import club.krislin.domain.Orders;
import club.krislin.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @ClassName IOrdersDao
 * @Description TODO
 * @Date 20/1/6 15:10
 * @Author LIM
 * @Version V1.0
 */
@Repository("ordersDao")
public interface IOrdersDao {
    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "club.krislin.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "club.krislin.dao.IProductDao.findById"))
    })
    Orders findById(int id);
}
