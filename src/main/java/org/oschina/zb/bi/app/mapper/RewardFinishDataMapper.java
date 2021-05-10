package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Reward;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 结项悬赏信息查询
 * 
 * @author ljw
 *
 */
@Mapper
public interface RewardFinishDataMapper extends BaseMapper<Reward> {
    /**
     * 悬赏类型统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> type(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏进度统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> schedule(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏金额统计-已托管总额
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> hostedTotalMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏金额统计-已解冻总额
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> withdrawTotalMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏平均值-项目单价
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageProjectPrice(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏平均值-竞标周期
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageApplyCycle(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏平均值-报名数量
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageApplyCount(@Param(value = "params") Map<String, Object> params);

    /**
     * 悬赏平均值-方案数量
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageSchemeCount(@Param(value = "params") Map<String, Object> params);

    /**
     * 结项项目评价统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> comment(@Param(value = "params") Map<String, Object> params);

}
