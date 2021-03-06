package club.krislin.dao;

import club.krislin.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @InterfaceName IProductDao
 * @Description dao接口
 * @Date 20/1/5 16:24
 * @Author LIM
 * @Version V1.0
 */
@Repository("productDao")
public interface IProductDao {
    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
    /**
     * 查找所有
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 添加
     *
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 删除产品
     *
     * @param productId
     * @throws Exception
     */
    @Delete("delete from product where id=#{productId}")
    void deleteProduct(int productId) throws Exception;

    /**
     * 删除订单
     *
     * @param productId
     * @throws Exception
     */
    @Delete("delete from orders where productId=#{productId}")
    void deleteOrder(int productId) throws Exception;
}
