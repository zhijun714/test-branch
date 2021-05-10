package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.Reward;
import org.oschina.zb.bi.app.mapper.RewardFinishDataMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class RewardFinishDataDao extends BaseDao<RewardFinishDataMapper, Reward> {
    /**
     * 悬赏类型统计
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> type(Map<String, Object> params) {
        return mapper.type(params);
    }

    /**
     * 结项项目进度统计
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> schedule(Map<String, Object> params) {
        return mapper.schedule(params);
    }

    /**
     * 悬赏金额统计-已托管总额
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> hostedTotalMoney(Map<String, Object> params) {
        return mapper.hostedTotalMoney(params);
    }

    /**
     * 悬赏金额统计-已解冻总额
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> withdrawTotalMoney(Map<String, Object> params) {
        return mapper.withdrawTotalMoney(params);
    }

    /**
     * 悬赏平均值-项目单价
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageProjectPrice(Map<String, Object> params) {
        return mapper.averageProjectPrice(params);
    }

    /**
     * 悬赏平均值-竞标周期
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageApplyCycle(Map<String, Object> params) {
        return mapper.averageApplyCycle(params);
    }

    /**
     * 悬赏平均值-报名数量
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageApplyCount(Map<String, Object> params) {
        return mapper.averageApplyCount(params);
    }

    /**
     * 悬赏平均值-方案数量
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageSchemeCount(Map<String, Object> params) {
        return mapper.averageSchemeCount(params);
    }

    /**
     * 结项项目评价统计
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> comment(Map<String, Object> params) {
        return mapper.comment(params);
    }

}
