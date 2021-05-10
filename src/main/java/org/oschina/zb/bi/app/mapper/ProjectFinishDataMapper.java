package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 结项项目信息查询
 * 
 * @author ljw
 *
 */
@Mapper
public interface ProjectFinishDataMapper extends BaseMapper<Project> {
    /**
     * 项目类型统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> type(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目进度统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> schedule(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目金额统计-合同总额
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> contractTotalMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目金额统计-已托管总额
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> hostedTotalMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目金额统计-已解冻总额
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> withdrawTotalMoney(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目平均值-单价
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageProjectPrice(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目平均值-实施周期
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageImplementationCycle(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目平均值-竞标周期
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageApplyCycle(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目平均值-报名数量
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> averageApplyCount(@Param(value = "params") Map<String, Object> params);

    /**
     * 结项项目评价统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> comment(@Param(value = "params") Map<String, Object> params);
}
