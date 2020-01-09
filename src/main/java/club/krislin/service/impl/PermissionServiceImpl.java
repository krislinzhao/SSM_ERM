package club.krislin.service.impl;

import club.krislin.dao.IPermissionDao;
import club.krislin.domain.Permission;
import club.krislin.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName PermissionServceImpl
 * @Description TODO
 * @Date 20/1/9 15:07
 * @Author LIM
 * @Version V1.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    /**
     * 查找其他权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return permissionDao.findOtherPermission(roleId);
    }

    /**
     * 查找所有
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return permissionDao.findAll();
    }

    /**
     * 添加
     *
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
