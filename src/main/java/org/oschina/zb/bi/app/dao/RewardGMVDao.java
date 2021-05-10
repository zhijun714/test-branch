package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.Reward;
import org.oschina.zb.bi.app.mapper.RewardGMVMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 
 * 悬赏GMV Dao
 * 
 * @author ljw
 */
@Repository
public class RewardGMVDao extends BaseDao<RewardGMVMapper, Reward> {

    /**
     * 平台交易额统计<br>
     * 托管总额部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionHostedMoney(Map<String, Object> params) {
        return mapper.transactionHostedMoney(params);
    }

    /**
     * 平台交易额统计<br>
     * 验收通过部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionCompleteMoney(Map<String, Object> params) {
        return mapper.transactionCompleteMoney(params);
    }

    /**
     * 平台交易额统计<br>
     * 退款总额部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionTerminatedMoney(Map<String, Object> params) {
        return mapper.transactionTerminatedMoney(params);
    }

}
