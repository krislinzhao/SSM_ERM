package club.krislin.service.impl;

import club.krislin.dao.IProductDao;
import club.krislin.domain.Product;
import club.krislin.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Date 20/1/5 16:27
 * @Author LIM
 * @Version V1.0
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {
    @Resource
    private IProductDao productDao;

    /**
     * 查找所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception {
        List<Product> productList = productDao.findAll();
        for (Product product:productList){
            System.out.println(product);
        }
        PageHelper.startPage(pageNum,pageSize);
        return productDao.findAll();
    }

    /**
     * 添加
     *
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    /**
     * 删除产品
     *
     * @param productId
     * @throws Exception
     */
    @Override
    public void deleteProduct(int productId) throws Exception {
        //删除product
        productDao.deleteProduct(productId);
        //删除order
        productDao.deleteOrder(productId);
    }
}
