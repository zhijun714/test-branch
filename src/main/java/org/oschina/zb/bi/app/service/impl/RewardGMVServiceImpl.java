package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.RewardGMVDao;
import org.oschina.zb.bi.app.service.RewardGMVService;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 悬赏GMVServiceImpl
 *
 * @author ljw
 */
@Service
public class RewardGMVServiceImpl extends BaseServiceImpl<RewardGMVDao> implements RewardGMVService {
    /**
     * 悬赏GMV列名
     */
    private String[] transactionCol = new String[] { "hostedMoney", "completeMoney", "terminatedMoney" };

    /**
     * 平台交易额统计
     */
    @Override
    public List<Map<String, Object>> transaction(Map<String, Object> params) {
        List<Map<String, Object>> transactionHostedMoney = dao.transactionHostedMoney(params);
        List<Map<String, Object>> transactionCompleteMoney = dao.transactionCompleteMoney(params);
        List<Map<String, Object>> transactionTerminatedMoney = dao.transactionTerminatedMoney(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(transactionHostedMoney, result, transactionCol[0]);
            ResultManager.mergeResultMapByDate(transactionCompleteMoney, result, transactionCol[1]);
            ResultManager.mergeResultMapByDate(transactionTerminatedMoney, result, transactionCol[2]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, transactionCol);
        ResultManager.addTotalResult(resultList, transactionCol);
        return resultList;
    }

}
