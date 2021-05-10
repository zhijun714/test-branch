package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.RewardFinishDataDao;
import org.oschina.zb.bi.app.service.RewardFinishDataService;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 结赏悬赏信息查询ServiceImpl
 * 
 * @author ljw
 *
 */
@Service
public class RewardFinishDataServiceImpl extends BaseServiceImpl<RewardFinishDataDao>
        implements RewardFinishDataService {

    /**
     * 悬赏类型列名
     */
    private String[] typeCol = new String[] { "mobile", "h5", "weixin", "company", "web", "tool", "desktop", "embedded",
            "game", "design", "train", "other", "personalEmployer", "companyEmployer", "personalContractor",
            "companyContractor" };
    /**
     * 悬赏进度列名
     */
    private String[] scheduleCol = new String[] { "normalCount", "beforeCount", "laterCount" };
    /**
     * 悬赏金额列名
     */
    private String[] moneyCol = new String[] { "hostedTotalMoney", "withdrawTotalMoney" };
    /**
     * 悬赏平均值列名
     */
    private String[] averageCol = new String[] { "avgPrice", "avgApplyCycle", "avgApplyCount", "avgSchemeCount" };
    /**
     * 悬赏评价列名
     */
    private String[] commentCol = new String[] { "good", "normal", "bad" };

    /**
     * 结项悬赏类型统计
     */
    @Override
    public List<Map<String, Object>> type(Map<String, Object> params) {
        List<Map<String, Object>> typeList = dao.type(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(32);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(typeList, result, typeCol);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, typeCol);
        ResultManager.addTotalResult(resultList, typeCol);
        return resultList;
    }

    /**
     * 结项项目进度统计
     */
    @Override
    public List<Map<String, Object>> schedule(Map<String, Object> params) {
        List<Map<String, Object>> scheduleList = dao.schedule(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(scheduleList, result, scheduleCol);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, scheduleCol);
        ResultManager.addTotalResult(resultList, scheduleCol);
        return resultList;
    }

    /**
     * 结项悬赏金额统计
     */
    @Override
    public List<Map<String, Object>> money(Map<String, Object> params) {
        List<Map<String, Object>> hostedTotalMoneyList = dao.hostedTotalMoney(params);
        List<Map<String, Object>> withdrawTotalMoneyList = dao.withdrawTotalMoney(params);
        int size = ResultManager.countListSize(params);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(hostedTotalMoneyList, result, moneyCol[0]);
            ResultManager.mergeResultMapByDate(withdrawTotalMoneyList, result, moneyCol[1]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, moneyCol);
        ResultManager.addTotalResult(resultList, moneyCol);
        return resultList;
    }

    /**
     * 结项悬赏平均值统计
     */
    @Override
    public List<Map<String, Object>> average(Map<String, Object> params) {
        List<Map<String, Object>> averageProjectPriceList = dao.averageProjectPrice(params);
        List<Map<String, Object>> averageApplyCycleList = dao.averageApplyCycle(params);
        List<Map<String, Object>> averageApplyCountList = dao.averageApplyCount(params);
        List<Map<String, Object>> averageSchemeCountList = dao.averageSchemeCount(params);
        int size = ResultManager.countListSize(params);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> result = new HashMap<String, Object>(8);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(averageProjectPriceList, result, averageCol[0]);
            ResultManager.mergeResultMapByDate(averageApplyCycleList, result, averageCol[1]);
            ResultManager.mergeResultMapByDate(averageApplyCountList, result, averageCol[2]);
            ResultManager.mergeResultMapByDate(averageSchemeCountList, result, averageCol[3]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, averageCol);
        ResultManager.addAvgResult(resultList, averageCol);
        return resultList;
    }

    /**
     * 结项悬赏评价统计
     */
    @Override
    public List<Map<String, Object>> comment(Map<String, Object> params) {
        List<Map<String, Object>> scheduleList = dao.comment(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(scheduleList, result, commentCol);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, commentCol);
        ResultManager.addTotalResult(resultList, commentCol);
        return resultList;
    }

}
