package club.krislin.service;

import club.krislin.domain.Role;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName IRoleService
 * @Description TODO
 * @Date 20/1/9 14:18
 * @Author LIM
 * @Version V1.0
 */
public interface IRoleService {
    /**
     * 查询所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Role> findAll(int pageNum, int pageSize) throws Exception;

    /**
     * 添加用户
     *
     * @param role
     * @throws Exception
     */
    void save(Role role) throws Exception;

    /**
     * 查找权限
     *
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findOtherRole(int userId) throws Exception;

    /**
     * 通过roleId查找role
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findById(int roleId) throws Exception;

    /**
     * 添加权限给角色
     *
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    void addPermissionToRole(int roleId, int[] permissionIds) throws Exception;

    /**
     * 通过roleId删除role
     *
     * @param roleId
     * @throws Exception
     */
    void deleteRole(int roleId) throws Exception;
}
