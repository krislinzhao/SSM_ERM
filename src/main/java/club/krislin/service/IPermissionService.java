package club.krislin.service;

import club.krislin.domain.Permission;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName IPermission
 * @Description TODO
 * @Date 20/1/9 15:06
 * @Author LIM
 * @Version V1.0
 */
public interface IPermissionService {

    /**
     * 查找所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Permission> findAll(int pageNum, int pageSize) throws Exception;

    /**
     * 添加
     *
     * @param permission
     * @throws Exception
     */
    void save(Permission permission) throws Exception;

    /**
     * 查找其他权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> findOtherPermission(int roleId) throws Exception;

    /**
     * 通过permissionId查询permission
     *
     * @param permissionId
     * @return
     * @throws Exception
     */
    Permission findById(int permissionId) throws Exception;

    /**
     * 通过permissionId删除permission
     *
     * @param permissionId
     * @throws Exception
     */
    void deletePermission(int permissionId) throws Exception;
}
