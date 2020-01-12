package club.krislin.dao;

import club.krislin.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @ClassName IUserDao
 * @Description TODO
 * @Date 20/1/8 15:58
 * @Author LIM
 * @Version V1.0
 */
@Repository("userDao")
public interface IUserDao {
    /**
     * 通过username查找
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "club.krislin.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查找所有
     *
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 保存user
     *
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users(email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 通过id查找用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "club.krislin.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int userId) throws Exception;

    /**
     * 添加权限给用户
     *
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId) throws Exception;
}
