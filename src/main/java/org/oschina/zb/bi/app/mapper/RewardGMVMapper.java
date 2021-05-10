package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Reward;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 悬赏GMV Mapper
 * 
 * @author ljw
 */
@Mapper
public interface RewardGMVMapper extends BaseMapper<Reward> {
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
     * 验收通过部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionCompleteMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 平台交易额统计<br>
     * 退款总额部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transactionTerminatedMoney(@Param(value = "params") Map<String, Object> params);

}