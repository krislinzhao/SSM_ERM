package club.krislin.controller;

import club.krislin.domain.SysLog;
import club.krislin.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName SysLogController
 * @Description TODO
 * @Date 20/1/10 14:31
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Resource
    private ISysLogService sysLogService;

    /**
     * 查询日志
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
