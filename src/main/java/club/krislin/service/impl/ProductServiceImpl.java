package club.krislin.service.impl;

import club.krislin.dao.IProductDao;
import club.krislin.domain.Product;
import club.krislin.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Date 20/1/5 16:27
 * @Author LIM
 * @Version V1.0
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
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
}
