package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.ProjectFinishDataDao;
import org.oschina.zb.bi.app.service.ProjectFinishDataService;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 结赏项目信息查询ServiceImpl
 * 
 * @author ljw
 *
 */
@Service
public class ProjectFinishDataServiceImpl extends BaseServiceImpl<ProjectFinishDataDao>
        implements ProjectFinishDataService {
    /**
     * 项目类型列名
     */
    private String[] typeCol = new String[] { "mobile", "h5", "weixin", "company", "web", "tool", "desktop", "embedded",
            "game", "design", "train", "other", "personalEmployer", "companyEmployer", "personalContractor",
            "companyContractor" };
    /**
     * 项目进度列名
     */
    private String[] scheduleCol = new String[] { "normalCount", "beforeCount", "laterCount" };
    /**
     * 项目金额列名
     */
    private String[] moneyCol = new String[] { "contractTotalMoney", "hostedTotalMoney", "withdrawTotalMoney" };
    /**
     * 项目平均值列名
     */
    private String[] averageCol = new String[] { "avgPrice", "avgImplementationCycle", "avgApplyCycle",
            "avgApplyCount" };
    /**
     * 项目评价列名
     */
    private String[] commentCol = new String[] { "good", "normal", "bad" };

    /**
     * 结项项目类型统计
     */
    @Override
    public List<Map<String, Object>> type(Map<String, Object> params) {
        List<Map<String, Object>> projectTypeList = dao.type(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(32);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(projectTypeList, result, typeCol);
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
     * 结项项目金额统计
     */
    @Override
    public List<Map<String, Object>> money(Map<String, Object> params) {
        List<Map<String, Object>> contractTotalMoneyList = dao.contractTotalMoney(params);
        List<Map<String, Object>> hostedTotalMoneyList = dao.hostedTotalMoney(params);
        List<Map<String, Object>> withdrawTotalMoneyList = dao.withdrawTotalMoney(params);
        int size = ResultManager.countListSize(params);
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(contractTotalMoneyList, result, moneyCol[0]);
            ResultManager.mergeResultMapByDate(hostedTotalMoneyList, result, moneyCol[1]);
            ResultManager.mergeResultMapByDate(withdrawTotalMoneyList, result, moneyCol[2]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, moneyCol);
        ResultManager.addTotalResult(resultList, moneyCol);
        return resultList;
    }

    /**
     * 结项项目平均值统计
     */
    @Override
    public List<Map<String, Object>> average(Map<String, Object> params) {
        List<Map<String, Object>> averageProjectPriceList = dao.averageProjectPrice(params);
        List<Map<String, Object>> averageImplementationCycleList = dao.averageImplementationCycle(params);
        List<Map<String, Object>> averageApplyCycleList = dao.averageApplyCycle(params);
        List<Map<String, Object>> averageApplyCountList = dao.averageApplyCount(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int size = ResultManager.countListSize(params);
        for (int i = 0; i < size; i++) {
            Map<String, Object> result = new HashMap<String, Object>(8);
            // 设置日期
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(averageProjectPriceList, result, averageCol[0]);
            ResultManager.mergeResultMapByDate(averageImplementationCycleList, result, averageCol[1]);
            ResultManager.mergeResultMapByDate(averageApplyCycleList, result, averageCol[2]);
            ResultManager.mergeResultMapByDate(averageApplyCountList, result, averageCol[3]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, averageCol);
        ResultManager.addAvgResult(resultList, averageCol);
        return resultList;
    }

    /**
     * 结项项目评价统计
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
