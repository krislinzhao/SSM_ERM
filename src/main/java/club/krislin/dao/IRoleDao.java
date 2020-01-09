package club.krislin.dao;

import club.krislin.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @InterfaceName IRoleDao
 * @Description TODO
 * @Date 20/1/8 16:06
 * @Author LIM
 * @Version V1.0
 */
@Repository
public interface IRoleDao {
    /**
     * 通过id查询role
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    List<Role> findRoleByUserId(Integer userId);

    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加用户
     *
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 查找其他权限
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRole(int userId) throws Exception;

    /**
     * 通过roleId查找role
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId) throws Exception;

    /**
     * 给角色分配权限
     *
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission(roleId,permissionId) value(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId) throws Exception;
}
