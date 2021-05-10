package org.oschina.zb.bi.app.dao;

import java.util.HashMap;
import java.util.Map;

import org.oschina.zb.bi.app.constant.ProjectStatusConstant;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.mapper.ProjectMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * 项目查询
 * 
 * @author ljw
 */
@Repository
public class ProjectDao extends BaseDao<ProjectMapper, Project> {
    /**
     * 计算项目总揽信息
     * 
     * @return
     */
    public Map<String, Object> getProjectTotal() {
        Map<String, Object> result = new HashMap<String, Object>();
        Wrapper<Project> wrapper = new EntityWrapper<Project>();
        int totalCount = selectCount(wrapper);
        result.put("totalCount", totalCount);
        
        wrapper = new EntityWrapper<Project>();
        wrapper.in("status_", new Integer[]{ProjectStatusConstant.IMPLEMENT, ProjectStatusConstant.COMPLETED, ProjectStatusConstant.TERMINATED});
        int dealCount = selectCount(wrapper);
        result.put("dealCount", dealCount);
        return result;
    }
}
