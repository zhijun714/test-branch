package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.mapper.ProjectFinishDataMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 结项项目信息查询
 * 
 * @author ljw
 *
 */
@Repository
public class ProjectFinishDataDao extends BaseDao<ProjectFinishDataMapper, Project> {
    /**
     * 项目类型统计
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
     * 项目金额统计-合同总额
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> contractTotalMoney(Map<String, Object> params) {
        return mapper.contractTotalMoney(params);
    }

    /**
     * 项目金额统计-已托管总额
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> hostedTotalMoney(Map<String, Object> params) {
        return mapper.hostedTotalMoney(params);
    }

    /**
     * 项目金额统计-已解冻总额
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> withdrawTotalMoney(Map<String, Object> params) {
        return mapper.withdrawTotalMoney(params);
    }

    /**
     * 项目平均值-单价
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageProjectPrice(Map<String, Object> params) {
        return mapper.averageProjectPrice(params);
    }

    /**
     * 项目平均值-实施周期
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageImplementationCycle(Map<String, Object> params) {
        return mapper.averageImplementationCycle(params);
    }

    /**
     * 项目平均值-竞标周期
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageApplyCycle(Map<String, Object> params) {
        return mapper.averageApplyCycle(params);
    }

    /**
     * 项目平均值-报名数量
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> averageApplyCount(Map<String, Object> params) {
        return mapper.averageApplyCount(params);
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
