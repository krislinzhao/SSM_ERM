package club.krislin.service;

import club.krislin.domain.SysLog;

import java.util.List;

/**
 * @Package club.krislin.service
 * @InterfaceName ISysLogService
 * @Description TODO
 * @Date 20/1/10 14:33
 * @Author LIM
 * @Version V1.0
 */
public interface ISysLogService {
    /**
     * 保存日志
     *
     * @param sysLog
     * @throws Exception
     */
    void save(SysLog sysLog) throws Exception;

    /**
     * 查找所有日志(分页)
     *
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<SysLog> findAll(int pageNum, int pageSize) throws Exception;
}
