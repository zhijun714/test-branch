package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.service.dto.HadRecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendSelectDTO;
import org.oschina.zb.bi.app.service.dto.UserProjectReturnDTO;
import org.oschina.zb.platform.core.base.BaseMapper;
import org.oschina.zb.platform.core.mybatis.Page;

/**
 * 项目与悬赏合并Mapper
 * 
 * @author ljw
 */
@Mapper
public interface OMSProjectRewardMapper extends BaseMapper<Project> {

    /**
     * 项目统计列表<br>
     * 发包方
     * 
     * @param userId
     * @return
     */
    List<UserProjectReturnDTO> totalListByEmployer(@Param(value = "params") RecommendSelectDTO recommendSelectDTO,
            @Param("page") Page<UserProjectReturnDTO> page);

    /**
     * 项目统计总数<br>
     * 发包方
     * 
     * @param userAccountId
     * @return
     */
    List<Map<String, Object>> totalCountByEmployer(@Param(value = "params") Map<String, Object> params);

    /**
     * 项目统计列表<br>
     * 接包方
     * 
     * @param userAccountId
     * @return
     */
    List<UserProjectReturnDTO> totalListByContractor(@Param(value = "params") RecommendSelectDTO recommendSelectDTO,
            @Param("page") Page<UserProjectReturnDTO> page);

    /**
     * 项目统计总数<br>
     * 接包方
     * 
     * @param userAccountId
     * @return
     */
    List<Map<String, Object>> totalCountByContractor(@Param(value = "params") Map<String, Object> params);

    /**
     * 综合评价<br>
     * 接包方&发包方通用
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> commentByUser(@Param(value = "params") Map<String, Object> params);

    /**
     * 用户已推荐项目 <br>
     * 列表部分
     * 
     * @param params
     * @return
     */
    List<HadRecommendReturnDTO> recommendListByUser(@Param(value = "params") RecommendSelectDTO recommendSelectDTO,
            @Param("page") Page<HadRecommendReturnDTO> page);

    /**
     * 用户已推荐项目 <br>
     * 总数部分
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> recommendCountByUser(@Param(value = "params") Map<String, Object> params);

    /**
     * 分页查询可推荐给用户的项目
     * 
     * @param recommendSelectDTO
     * @return
     */
    List<RecommendReturnDTO> canRecommendList(@Param(value = "params") RecommendSelectDTO recommendSelectDTO,
            @Param("page") Page<RecommendReturnDTO> page);

    /**
     * 用户是否竞标指定项目
     * @param userAccountId
     * @param projectId
     * @return >0=已竞标，0=未竞标
     */
    int checkApplyProject(@Param(value = "userAccountId") Long userAccountId, @Param(value = "projectId")  Long projectId);
    
    /**
     * 用户是否竞标指定悬赏
     * @param userAccountId
     * @param rewardId
     * @return >0=已竞标，0=未竞标
     */
    int checkApplyReward(@Param(value = "userAccountId") Long userAccountId, @Param(value = "rewardId")  Long rewardId);
}
