package club.krislin.service.impl;

import club.krislin.dao.IUserDao;
import club.krislin.domain.Role;
import club.krislin.domain.UserInfo;
import club.krislin.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 20/1/8 15:55
 * @Author LIM
 * @Version V1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 添加权限给用户
     *
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void addRoleToUser(int userId, int[] roleIds) throws Exception {
        for (int roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(int userId) throws Exception {
        return userDao.findById(userId);
    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 作用就是返回一个list集合,装入的就是角色的描述
     *
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    /**
     * 添加账户
     *
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /**
     * 查找所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.findAll();
    }
}
