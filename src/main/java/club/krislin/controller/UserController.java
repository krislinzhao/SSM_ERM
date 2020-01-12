package club.krislin.controller;

import club.krislin.domain.Role;
import club.krislin.domain.UserInfo;
import club.krislin.service.IRoleService;
import club.krislin.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.controller
 * @ClassName UserController
 * @Description TODO
 * @Date 20/1/8 16:49
 * @Author LIM
 * @Version V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;

    /**
     * 查询所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> users = userService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(users);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 用户添加
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == tom")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:/user/findAll.do";
    }

    /**
     * 查询指定id的用户
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "userId") int userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "userId") int userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> roleList = roleService.findOtherRole(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") int userId,
                                @RequestParam(name = "roleIds") int[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:/user/findAll.do";
    }
}
