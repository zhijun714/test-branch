package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.mapper.ProjectRewardMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 项目与悬赏合并Dao
 * 
 * @author ljw
 *
 */
@Repository
public class ProjectRewardDao extends BaseDao<ProjectRewardMapper, Project> {
    /**
     * 类型统计-项目
     * 
     * @param params
     * @return
     */
    public Map<String, Object> projectType(Map<String, Object> params) {
        return mapper.projectType(params).get(0);
    }

    /**
     * 类型统计-悬赏
     * 
     * @param params
     * @return
     */
    public Map<String, Object> rewardType(Map<String, Object> params) {
        return mapper.rewardType(params).get(0);
    }

    /**
     * 新增统计-项目
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> projectNew(Map<String, Object> params) {
        return mapper.projectNew(params);
    }

    /**
     * 新增统计-悬赏
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> rewardNew(Map<String, Object> params) {
        return mapper.rewardNew(params);
    }

}
