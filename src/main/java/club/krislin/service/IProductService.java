package club.krislin.service;

import club.krislin.domain.Product;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName IProductService
 * @Description service接口
 * @Date 20/1/5 16:25
 * @Author LIM
 * @Version V1.0
 */
public interface IProductService {
    /**
     * 查找所有
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 添加
     *
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;

    /**
     * 删除产品
     *
     * @param productId
     * @throws Exception
     */
    void deleteProduct(int productId) throws Exception;
}
