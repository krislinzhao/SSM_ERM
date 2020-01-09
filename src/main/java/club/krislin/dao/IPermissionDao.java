package club.krislin.dao;

import club.krislin.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @InterfaceName IPermissionDao
 * @Description TODO
 * @Date 20/1/9 15:09
 * @Author LIM
 * @Version V1.0
 */
@Repository
public interface IPermissionDao {
    /**
     * 查询所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    /**
     * 添加
     *
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(permission,url) values(#{permission},#{url})")
    void save(Permission permission) throws Exception;

    /**
     * 查找其他权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(int roleId) throws Exception;
}
