package club.krislin.controller;

import club.krislin.domain.Product;
import club.krislin.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private IProductService productService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public  String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }
}
