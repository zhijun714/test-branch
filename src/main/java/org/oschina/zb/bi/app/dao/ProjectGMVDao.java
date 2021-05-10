package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.mapper.ProjectGMVMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 项目GMV Dao
 * 
 * @author ljw
 */
@Repository
public class ProjectGMVDao extends BaseDao<ProjectGMVMapper, Project> {
    /**
     * 平台交易额统计<br>
     * 托管保证金部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionDepositMoney(Map<String, Object> params) {
        return mapper.transactionDepositMoney(params);
    }

    /**
     * 平台交易额统计<br>
     * 合同总额部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionContractMoney(Map<String, Object> params) {
        return mapper.transactionContractMoney(params);
    }

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
     * 验收通过总额部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionCompleteMoney(Map<String, Object> params) {
        return mapper.transactionCompleteMoney(params);
    }

    /**
     * 平台交易额统计<br>
     * 已解冻总额部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionThawedMoney(Map<String, Object> params) {
        return mapper.transactionThawedMoney(params);
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

    /**
     * 平台交易额统计<br>
     * 追加工作计划款部分
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> transactionAppendMoney(Map<String, Object> params) {
        return mapper.transactionAppendMoney(params);
    }

}
