package club.krislin.dao;

import club.krislin.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Package club.krislin.dao
 * @InterfaceName IMemberDao
 * @Description TODO
 * @Date 20/1/8 11:19
 * @Author LIM
 * @Version V1.0
 */
@Repository("memberDao")
public interface IMemberDao {
    /**
     * 通过memberId查询
     *
     * @param memberId
     * @return
     */
    @Select("select * from member where id =#{memberId}")
    Member findById(int memberId);
}
