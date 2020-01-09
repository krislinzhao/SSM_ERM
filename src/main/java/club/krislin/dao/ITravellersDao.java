package club.krislin.dao;

import club.krislin.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @InterfaceName ITravellersDao
 * @Description TODO
 * @Date 20/1/8 11:23
 * @Author LIM
 * @Version V1.0
 */
@Repository("travellersDao")
public interface ITravellersDao {
    /**
     * 传入orderId通过一张中间表order_traveller查询出traveller
     *
     * @param orderId
     * @return
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    List<Traveller> findByOrdersId(int orderId);
}
