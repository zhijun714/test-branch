package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 项目GMV Mapper
 * 
 * @author ljw
 */
@Mapper
public interface ProjectGMVMapper extends BaseMapper<Project> {
    /**
     * 平台交易额统计<br>
     * 托管保证金部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionDepositMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 合同总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionContractMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 托管总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionHostedMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 验收通过总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionCompleteMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 已解冻总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionThawedMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 退款总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionTerminatedMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 追加工作计划款部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionAppendMoney(@Param(value = "params") Map<String, Object> params);

}
