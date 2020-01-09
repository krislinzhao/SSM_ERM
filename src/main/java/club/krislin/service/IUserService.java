package club.krislin.service;

import club.krislin.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName IUserService
 * @Description TODO
 * @Date 20/1/8 15:53
 * @Author LIM
 * @Version V1.0
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查找所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll(int pageNum, int pageSize) throws Exception;

    /**
     * 保存账户
     *
     * @param userInfo
     * @throws Exception
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     * @throws Exception
     */
    UserInfo findById(int userId) throws Exception;

    /**
     * 添加权限给用户
     *
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    void addRoleToUser(int userId, int[] roleIds) throws Exception;
}
