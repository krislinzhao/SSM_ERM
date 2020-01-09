package club.krislin.controller;

import club.krislin.domain.Permission;
import club.krislin.domain.Role;
import club.krislin.service.IPermissionService;
import club.krislin.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName RoleController
 * @Description TODO
 * @Date 20/1/9 14:15
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "roleId") int roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(roleId);
        modelAndView.addObject("role", role);
        List<Permission> permissionList = permissionService.findOtherPermission(roleId);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") int roleId,
                                      @RequestParam(name = "permissionIds") int[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }
}
