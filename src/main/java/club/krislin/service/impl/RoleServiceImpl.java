package club.krislin.service.impl;

import club.krislin.dao.IRoleDao;
import club.krislin.domain.Role;
import club.krislin.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Date 20/1/9 14:19
 * @Author LIM
 * @Version V1.0
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Resource
    private IRoleDao roleDao;

    /**
     * 添加权限给角色
     *
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) throws Exception {
        for (int permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

    /**
     * 通过roleId查找role
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    /**
     * 查找权限
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findOtherRole(int userId) throws Exception {
        return roleDao.findOtherRole(userId);
    }

    /**
     * 添加用户
     *
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 通过roleId删除role
     *
     * @param roleId
     * @throws Exception
     */
    @Override
    public void deleteRole(int roleId) throws Exception {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    /**
     * 查询所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return roleDao.findAll();
    }
}
