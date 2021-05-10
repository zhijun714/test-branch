package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.UserAccount;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */
@Mapper
public interface OtherMapper extends BaseMapper<UserAccount> {

	public List<Map> userAccountFindByName(@Param("name") String name);
	
	public Map userContractorFindByUserAccountId(@Param("userAccountId") Long userAccountId);
	
	
	public void userContractorInsert(Map<String, Object> param);

	public void userContractorUpdate(Map<String, Object> param);

}
