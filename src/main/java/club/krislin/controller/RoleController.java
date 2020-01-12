package club.krislin.controller;

import club.krislin.domain.Permission;
import club.krislin.domain.Role;
import club.krislin.service.IPermissionService;
import club.krislin.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
    @Resource
    private IRoleService roleService;
    @Resource
    private IPermissionService permissionService;

    /**
     * 查询所有角色
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
        List<Role> roles = roleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(roles);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }

    /**
     * 角色详情查询
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "roleId") int roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(roleId);
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "roleId") int roleId) throws Exception {
        roleService.deleteRole(roleId);
        return "redirect:/role/findAll.do";
    }

    /**
     * 根据roleId查询role，并查询出可以添加的权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "roleId") int roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据roleId查询role
        Role role = roleService.findById(roleId);
        modelAndView.addObject("role", role);
        //2.根据roleId查询可以添加的权限
        List<Permission> permissionList = permissionService.findOtherPermission(roleId);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 给角色添加权限
     *
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") int roleId,
                                      @RequestParam(name = "permissionIds") int[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:/role/findAll.do";
    }
}
