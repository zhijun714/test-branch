package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.UserAccount;
import org.oschina.zb.bi.app.mapper.UserAccountMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */
@Repository
public class UserAccountDao extends BaseDao<UserAccountMapper, UserAccount> {

	/**
	 * 注册用户
	 * @param params
	 * @return
	 */
	public Page userInfo(Map<String, Object> params, Page page){
		page.setData(mapper.userInfo(params,page));
		return page;
	}

	/**
	 * 发包用户
	 * @param params
	 * @param page
	 * @return
	 */
	public Page contractIssuing(Map<String, Object> params, Page page){
		page.setData(mapper.contractIssuing(params,page));
		return page;
	}

	/**
	 * 接包用户
	 * @return
	 */
	public Page contractReceiver(Map<String, Object> params, Page page){
		page.setData(mapper.contractReceiver(params,page));
		return page;
	}

	/**
	 * 接包用户的搜索
	 * @param params
	 * @param page
	 * @return
	 */
	public Page contractReceiverSearch(Map<String, Object> params, Page page){
		page.setData(mapper.contractReceiverSearch(params,page));
		return page;
	}



	/**
	 * 用户基本信息
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> userBasicInfo(Map<String, Object> params) {
		return mapper.userBasicInfo(params);
	}

	/**
	 * 发过包的发包方
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> operationalEmployer(Map<String, Object> params) {
		return mapper.operationalEmployer(params);
	}

	/**
	 * 接过包的接包方
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> operationalContractor(Map<String, Object> params) {
		return mapper.operationalContractor(params);
	}

	/**
	 * 新增未激活用户统计
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> userNew(Map<String, Object> params) {
		return mapper.userNew(params);
	}

	/**
	 * 新增激活用户统计
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> userAccountNew(Map<String, Object> params) {
		return mapper.userAccountNew(params);
	}

	/**
	 * 用户帐户增长趋势统计
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> growUserAccount(Map<String, Object> params) {
		return mapper.growUserAccount(params);
	}

	/**
	 * 用户发包方增长趋势统计
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> growEmployer(Map<String, Object> params) {
		return mapper.growEmployer(params);
	}

	/**
	 * 用户接包方增长趋势统计
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> growContractor(Map<String, Object> params) {
		return mapper.growContractor(params);
	}

	/**
	 * 指定日期以前的用户帐户数量
	 * 
	 * @param
	 * @return
	 */
	public int userAccountCountOfBeforeDate(Map<String, Object> params) {
		EntityWrapper<UserAccount> wrapper = new EntityWrapper<>();
		wrapper.lt("created_at_", params.get("beginDate"));
		return selectCount(wrapper);
	}

	/**
	 * 指定日期前的发包方数量
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> employerCountOfBeforeDate(Map<String, Object> params) {
		return mapper.employerCountOfBeforeDate(params);
	}

	/**
	 * 指定日期前的接包方数量
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> contractorCountOfBeforeDate(Map<String, Object> params) {
		return mapper.contractorCountOfBeforeDate(params);
	}

	/**
	 * 指定日期的竞标过的接包方数量
	 * 
	 * @param params
	 * @return
	 */
	public Map<String, Object> biddedContractor(Map<String, Object> params) {
		return mapper.biddedContractor(params);
	}
}
