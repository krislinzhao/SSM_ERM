package club.krislin.controller;

import club.krislin.domain.Orders;
import club.krislin.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName OrdersController
 * @Description TODO
 * @Date 20/1/6 15:08
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    /**
     * 所有订单查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    /**
     * 订单详情
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "ordersId", required = true) Integer ordersId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("ordersId=" + ordersId);
        Orders orders = ordersService.findById(ordersId);
        System.out.println(orders);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
