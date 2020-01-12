package club.krislin.controller;

import club.krislin.domain.Product;
import club.krislin.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName ProductController
 * @Description TODO
 * @Date 20/1/5 17:12
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private IProductService productService;

    /**
     * 查询所有产品
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 添加产品
     *
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:/product/findAll.do";
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(@RequestParam(name = "productId") int productId) throws Exception {
        productService.deleteProduct(productId);
        return "redirect:/product/findAll.do";
    }
}
