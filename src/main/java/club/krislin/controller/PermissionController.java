package club.krislin.controller;

import club.krislin.domain.Permission;
import club.krislin.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName PermissionController
 * @Description TODO
 * @Date 20/1/9 14:58
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private IPermissionService permissionService;

    /**
     * 通过permissionId删除permission
     *
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deletePermission.do")
    public String deletePermission(@RequestParam(name = "permissionId") int permissionId) throws Exception {
        permissionService.deletePermission(permissionId);
        return "redirect:/permission/findAll.do";
    }

    /**
     * 通过permissionId查询permission
     *
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "permissionId") int permissionId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = permissionService.findById(permissionId);
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }

    /**
     * 查询所有权限
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
        List<Permission> permissions = permissionService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(permissions);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    /**
     * 添加权限
     *
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:/permission/findAll.do";
    }
}
