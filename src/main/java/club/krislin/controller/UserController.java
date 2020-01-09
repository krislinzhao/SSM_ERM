package club.krislin.controller;

import club.krislin.domain.Role;
import club.krislin.domain.UserInfo;
import club.krislin.service.IRoleService;
import club.krislin.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> users = userService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(users);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "userId") int userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "userId") int userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> roleList = roleService.findOtherRole(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") int userId,
                                @RequestParam(name = "roleIds") int[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }
}
