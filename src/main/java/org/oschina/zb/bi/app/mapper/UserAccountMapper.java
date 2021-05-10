package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.UserAccount;
import org.oschina.zb.platform.core.base.BaseMapper;
import org.oschina.zb.platform.core.mybatis.Page;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {

	/**
	 * 注册用户信息
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> userInfo(@Param("params") Map<String, Object> params,@Param("page") Page page);

	List<Map<String,Object>> contractIssuing(@Param("params") Map<String, Object> params,@Param("page") Page page);

	List<Map<String,Object>> contractReceiver(@Param("params") Map<String, Object> params, @Param("page") Page page);

	List<Map<String,Object>> contractReceiverSearch(@Param("params") Map<String, Object> params, @Param("page") Page page);



	/**
	 * 用户基本信息
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> userBasicInfo(@Param("params") Map<String, Object> params);

	/**
	 * 发过包的发包方
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> operationalEmployer(@Param("params") Map<String, Object> params);

	/**
	 * 接过包的接包方
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> operationalContractor(@Param("params") Map<String, Object> params);

	/**
	 * 新增未激活用户统计
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> userNew(@Param("params") Map<String, Object> params);

	/**
	 * 新增激活用户统计
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> userAccountNew(@Param("params") Map<String, Object> params);

	/**
	 * 用户帐户趋势统计
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> growUserAccount(@Param("params") Map<String, Object> params);

	/**
	 * 用户发包方趋势统计
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> growEmployer(@Param("params") Map<String, Object> params);

	/**
	 * 用户接包方趋势统计
	 * 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> growContractor(@Param("params") Map<String, Object> params);

	/**
	 * 指定日期前的发包方数量
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> employerCountOfBeforeDate(@Param("params") Map<String, Object> params);

	/**
	 * 指定日期前的接包方数量
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> contractorCountOfBeforeDate(@Param("params") Map<String, Object> params);

	/**
	 * 指定日期的竞标过的接包方数量
	 * 
	 * @param params
	 * @return
	 */
	Map<String, Object> biddedContractor(@Param("params") Map<String, Object> params);

}
