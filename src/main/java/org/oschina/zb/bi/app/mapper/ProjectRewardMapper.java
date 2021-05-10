package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 项目与悬赏合并Mapper
 * 
 * @author ljw
 */
@Mapper
public interface ProjectRewardMapper extends BaseMapper<Project> {

    /**
     * 类型统计-项目
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> projectType(@Param(value = "params") Map<String, Object> params);

    /**
     * 类型统计-悬赏
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> rewardType(@Param(value = "params") Map<String, Object> params);

    /**
     * 新增统计-项目
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> projectNew(@Param(value = "params") Map<String, Object> params);

    /**
     * 新增统计-悬赏
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> rewardNew(@Param(value = "params") Map<String, Object> params);

}
