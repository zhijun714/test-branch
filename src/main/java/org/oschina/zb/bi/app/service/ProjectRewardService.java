package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.ProjectRewardDao;
import org.oschina.zb.bi.app.service.dto.HadRecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendSelectDTO;
import org.oschina.zb.bi.app.service.dto.UserProjectReturnDTO;
import org.oschina.zb.platform.core.base.BaseService;
import org.oschina.zb.platform.core.mybatis.Page;

/**
 * 项目与悬赏合并Service
 * 
 * @author ljw
 *
 */
public interface ProjectRewardService extends BaseService<ProjectRewardDao> {
    /**
     * 类型统计
     * 
     * @param params
     * @return
     */
    Map<String, Object> type(Map<String, Object> params);

    /**
     * 新增统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> newProjectReward(Map<String, Object> params);

    /**
     * 总数统计
     * 
     * @param params
     * @return
     */
    Map<String, Object> total();

    /**
     * 用户项目总数统计-列表部分
     * 
     * @param recommendDTO
     * @return
     */
    Page<UserProjectReturnDTO> totalListByUser(RecommendSelectDTO recommendDTO);

    /**
     * 用户项目总数统计-总数部分
     * 
     * @param recommendDTO
     * @return
     */
    Map<String, Object> totalCountByUser(RecommendSelectDTO recommendDTO);

    /**
     * 用户项目推荐项目统计-列表部分
     * 
     * @param recommendDTO
     * @return
     */
    Page<HadRecommendReturnDTO> recommendListByUser(RecommendSelectDTO recommendDTO);

    /**
     * 用户项目推荐项目统计-总数部分
     * 
     * @param recommendDTO
     * @return
     */
    Map<String, Object> recommendCountByUser(RecommendSelectDTO recommendDTO);

    /**
     * 分页查询可推荐给用户的项目
     * 
     * @param recommendDTO
     * @return
     */
    Page<RecommendReturnDTO> canRecommendList(RecommendSelectDTO recommendDTO);
    
    /**
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> grow(Map<String, Object> params);
}
