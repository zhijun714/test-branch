package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.ProjectGMVDao;
import org.oschina.zb.bi.app.service.ProjectGMVService;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 项目GMV ServiceImpl
 * 
 * @author ljw
 */
@Service
public class ProjectGMVServiceImpl extends BaseServiceImpl<ProjectGMVDao> implements ProjectGMVService {
    /**
     * 项目GMV列名
     */
    private String[] transactionCol = new String[] { "depositMoney", "contractMoney", "hostedMoney", "completeMoney",
            "thawedMoney", "terminatedMoney", "appendMoney", "totalContractMoney" };

    /**
     * 平台交易额统计
     */
    @Override
    public List<Map<String, Object>> transaction(Map<String, Object> params) {
        List<Map<String, Object>> transactionDepositMoney = dao.transactionDepositMoney(params);
        List<Map<String, Object>> transactionContractMoney = dao.transactionContractMoney(params);
        List<Map<String, Object>> transactionHostedMoney = dao.transactionHostedMoney(params);
        List<Map<String, Object>> transactionCompleteMoney = dao.transactionCompleteMoney(params);
        List<Map<String, Object>> transactionThawedMoney = dao.transactionThawedMoney(params);
        List<Map<String, Object>> transactionTerminatedMoney = dao.transactionTerminatedMoney(params);
        List<Map<String, Object>> transactionAppendMoney = dao.transactionAppendMoney(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(8);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(transactionDepositMoney, result, transactionCol[0]);
            ResultManager.mergeResultMapByDate(transactionContractMoney, result, transactionCol[1]);
            ResultManager.mergeResultMapByDate(transactionHostedMoney, result, transactionCol[2]);
            ResultManager.mergeResultMapByDate(transactionCompleteMoney, result, transactionCol[3]);
            ResultManager.mergeResultMapByDate(transactionThawedMoney, result, transactionCol[4]);
            ResultManager.mergeResultMapByDate(transactionTerminatedMoney, result, transactionCol[5]);
            ResultManager.mergeResultMapByDate(transactionAppendMoney, result, transactionCol[6]);
            result.put("totalContractMoney", Double
                    .valueOf(result.get("contractMoney") == null ? "0" : result.get("contractMoney").toString())
                    + Double.valueOf(result.get("appendMoney") == null ? "0" : result.get("appendMoney").toString()));
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, transactionCol);
        ResultManager.addTotalResult(resultList, transactionCol);
        return resultList;
    }

}
