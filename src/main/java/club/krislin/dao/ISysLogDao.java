package club.krislin.dao;

import club.krislin.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package club.krislin.dao
 * @InterfaceName ISysLogDao
 * @Description TODO
 * @Date 20/1/10 14:36
 * @Author LIM
 * @Version V1.0
 */
@Repository("sysLogDao")
public interface ISysLogDao {
    /**
     * 保存日志
     *
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询所有日志
     *
     * @return
     * @throws Exception
     */
    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;
}
