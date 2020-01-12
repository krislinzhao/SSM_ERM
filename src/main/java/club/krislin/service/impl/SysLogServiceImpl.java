package club.krislin.service.impl;

import club.krislin.dao.ISysLogDao;
import club.krislin.domain.SysLog;
import club.krislin.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package club.krislin.service.impl
 * @ClassName SysLogServiceImpl
 * @Description TODO
 * @Date 20/1/10 14:35
 * @Author LIM
 * @Version V1.0
 */
@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {
    @Resource
    private ISysLogDao sysLogDao;

    /**
     * 保存日志
     *
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    /**
     * 查找所有日志(分页)
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public List<SysLog> findAll(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return sysLogDao.findAll();
    }
}
