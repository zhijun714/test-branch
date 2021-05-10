package org.oschina.zb.bi.app.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.UserAccountDao;
import org.oschina.zb.bi.app.service.UserAccountService;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.bi.app.util.NumberUtil;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.stereotype.Service;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */
@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccountDao> implements UserAccountService {

	/**
	 * 注册用户
	 * @param params
	 * @return
	 */
	@Override
	public Page userInfo(Map<String, Object> params, Page page){
		return dao.userInfo(params,page);
	}

	@Override
	public Page contractIssuing(Map<String, Object> params, Page page){
		return dao.contractIssuing(params,page);
	}

	@Override
	public Page contractReceiver(Map<String, Object> params, Page page){
		return dao.contractReceiver(params,page);
	}

	@Override
    public Page contractReceiverSearch(Map<String, Object> params, Page page){
        return dao.contractReceiverSearch(params,page);
    }

	/**
	 * 新增用户统计列名
	 */
	private String[] userNewCol = new String[] { "employer", "contractor", "unActive" };

	/**
	 * 用户增长趋势列名
	 */
	private String[] userGrowCol = new String[] { "total", "employer", "contractor", "companyOfEmployer",
			"personalOfEmployer", "companyOfContractor", "personalOfContractor" };

	/**
	 * 用户数据总览
	 */
	@Override
	public Map<String, Object> overview(Map<String, Object> params) {
		// 查询出用户基础数据，实际发过包用户数，实际接过包用户数
		Map<String, Object> userBasicInfo = dao.userBasicInfo(params);
		Map<String, Object> operationalEmployer = dao.operationalEmployer(params);
		Map<String, Object> operationalContractor = dao.operationalContractor(params);
		Map<String, Object> biddedContractor = dao.biddedContractor(params);
		// 合并结果
		userBasicInfo.putAll(operationalEmployer);
		userBasicInfo.putAll(operationalContractor);
		userBasicInfo.putAll(biddedContractor);
		BigDecimal employer = (BigDecimal) userBasicInfo.get("employer");
		BigDecimal contractor = (BigDecimal) userBasicInfo.get("contractor");
		long employerNumber = 0L;
		long contractorNumber = 0L;
		double rateOfEmployer = 0.0;
		double rateOfContractor = 0.0;
		double rateOfOperationalEmployer = 0.0;
		double rateOfOperationalContractor = 0.0;
		double rateOfBiddedContractor = 0.0;
		// 计算发包率和接包率
		if (employer != null && (employerNumber = employer.longValue()) > 0) {
			rateOfOperationalEmployer = NumberUtil.getDoublePercent((Long) userBasicInfo.get("operationalEmployer"),
					employerNumber);
		}
		if (contractor != null && (contractorNumber = contractor.longValue()) > 0) {
			rateOfOperationalContractor = NumberUtil.getDoublePercent((Long) userBasicInfo.get("operationalContractor"),
					contractorNumber);
			rateOfBiddedContractor = NumberUtil.getDoublePercent((Long) userBasicInfo.get("biddedContractor"),
					contractorNumber);
		}
		if (contractor != null && (contractorNumber = contractor.longValue()) > 0) {
			rateOfOperationalContractor = NumberUtil.getDoublePercent((Long) userBasicInfo.get("operationalContractor"),
					contractorNumber);
		}
		// 计算接发包方角色占比
		if (employerNumber > 0 && contractorNumber > 0) {
			rateOfEmployer = NumberUtil.getDoublePercent(employerNumber, (employerNumber + contractorNumber));
			rateOfContractor = NumberUtil.getDoublePercent(contractorNumber, employerNumber + contractorNumber);
		}
		userBasicInfo.put("rateOfOperationalEmployer", rateOfOperationalEmployer);
		userBasicInfo.put("rateOfOperationalContractor", rateOfOperationalContractor);
		userBasicInfo.put("rateOfBiddedContractor", rateOfBiddedContractor);
		userBasicInfo.put("rateOfEmployer", rateOfEmployer);
		userBasicInfo.put("rateOfContractor", rateOfContractor);
		return userBasicInfo;
	}

	/**
	 * 新增用户统计
	 */
	@Override
	public List<Map<String, Object>> newUser(Map<String, Object> params) {
		List<Map<String, Object>> userNewList = dao.userNew(params);
		List<Map<String, Object>> userAccountNewList = dao.userAccountNew(params);
		int size = ResultManager.countListSize(params);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Map<String, Object> result = new HashMap<String, Object>();
			ResultManager.mergeDateToResultMap(result, params);
			ResultManager.mergeResultMapByDate(userAccountNewList, result, userNewCol[0]);
			ResultManager.mergeResultMapByDate(userAccountNewList, result, userNewCol[1]);
			ResultManager.mergeResultMapByDate(userNewList, result, userNewCol[2]);
			resultList.add(result);
		}
		ResultManager.changeNullToZero(resultList, userNewCol);
		return resultList;
	}

	/**
	 * 用户增长趋势统计
	 */
	@Override
	public Map<String, Object> grow(Map<String, Object> params) {
		List<Map<String, Object>> userAccountGrowList = dao.growUserAccount(params);
		List<Map<String, Object>> userEmployerGrowList = dao.growEmployer(params);
		List<Map<String, Object>> userContractorGrowList = dao.growContractor(params);
		int size = ResultManager.countListSize(params);
		List<Map<String, Object>> resultList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Map<String, Object> result = new HashMap<String, Object>();
			ResultManager.mergeDateToResultMap(result, params);
			ResultManager.mergeResultMapByDate(userEmployerGrowList, result, userGrowCol);
			ResultManager.mergeResultMapByDate(userContractorGrowList, result, userGrowCol);
			ResultManager.mergeResultMapByDate(userAccountGrowList, result, userGrowCol);
			resultList.add(result);
		}
		ResultManager.changeNullToZero(resultList, userGrowCol);

		// 计算以前的数据总数
		Map<String, Object> beforeCountMap = new HashMap<>();
		beforeCountMap.putAll(dao.contractorCountOfBeforeDate(params));
		beforeCountMap.putAll(dao.employerCountOfBeforeDate(params));
		beforeCountMap.put("total", dao.userAccountCountOfBeforeDate(params));

		// 合并数据并返回
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("growList", ResultManager.changeListToMap(resultList, userGrowCol));
		resultMap.put("beforeCountMap", beforeCountMap);
		return resultMap;
	}

}
