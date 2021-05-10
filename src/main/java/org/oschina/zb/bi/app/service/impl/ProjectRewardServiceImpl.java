package org.oschina.zb.bi.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.OMSProjectRewardDao;
import org.oschina.zb.bi.app.dao.ProjectDao;
import org.oschina.zb.bi.app.dao.ProjectRewardDao;
import org.oschina.zb.bi.app.dao.RewardDao;
import org.oschina.zb.bi.app.feign.manager.CommentFeignAppManager;
import org.oschina.zb.bi.app.service.ProjectRewardService;
import org.oschina.zb.bi.app.service.dto.HadRecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendSelectDTO;
import org.oschina.zb.bi.app.service.dto.UserProjectReturnDTO;
import org.oschina.zb.bi.app.service.manager.ResultManager;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目与悬赏合并ServiceImpl
 * 
 * @author ljw
 *
 */
@Service
public class ProjectRewardServiceImpl extends BaseServiceImpl<ProjectRewardDao> implements ProjectRewardService {

    /**
     * 新增统计列明
     */
    private String[] newCol = new String[] { "projectCount", "rewardCount" };

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private OMSProjectRewardDao omsProjectRewardDao;
    @Autowired
    private CommentFeignAppManager commentFeignAppManager;

    /**
     * 类型统计
     */
    @Override
    public Map<String, Object> type(Map<String, Object> params) {
        Map<String, Object> projectType = dao.projectType(params);
        Map<String, Object> reawrdType = dao.rewardType(params);
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put("project", projectType);
        result.put("reward", reawrdType);
        return result;
    }

    /**
     * 新增统计
     */
    @Override
    public List<Map<String, Object>> newProjectReward(Map<String, Object> params) {
        List<Map<String, Object>> projectNewList = dao.projectNew(params);
        List<Map<String, Object>> reawrdNewList = dao.rewardNew(params);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        int listSize = ResultManager.countListSize(params);
        for (int i = 0; i < listSize; i++) {
            Map<String, Object> result = new HashMap<String, Object>(4);
            ResultManager.mergeDateToResultMap(result, params);
            ResultManager.mergeResultMapByDate(projectNewList, result, newCol[0]);
            ResultManager.mergeResultMapByDate(reawrdNewList, result, newCol[1]);
            resultList.add(result);
        }
        ResultManager.changeNullToZero(resultList, newCol);
        return resultList;
    }

    /**
     * 总数统计
     */
    @Override
    public Map<String, Object> total() {
        Map<String, Object> project = projectDao.getProjectTotal();
        Map<String, Object> reward = rewardDao.getRewardTotal();
        Map<String, Object> result = new HashMap<>();
        result.put("project", project);
        result.put("reward", reward);
        return result;
    }

    /**
     * 用户项目总数统计-列表部分
     */
    @Override
    public Page<UserProjectReturnDTO> totalListByUser(RecommendSelectDTO recommendDTO) {
        if (recommendDTO.getIsEmployer() == 1) {
            return omsProjectRewardDao.totalListByEmployer(recommendDTO);
        } else {
            return omsProjectRewardDao.totalListByContractor(recommendDTO);
        }
    }

    /**
     * 用户项目总数统计-总数部分
     */
    @Override
    public Map<String, Object> totalCountByUser(RecommendSelectDTO recommendDTO) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        if (recommendDTO.getIsEmployer() == 1) {
            result = omsProjectRewardDao.totalCountByEmployer(recommendDTO.getUserAccountId());
        } else {
            result = omsProjectRewardDao.totalCountByContractor(recommendDTO.getUserAccountId());
        }
        // 合并评价数据
        result.put("comment",
                omsProjectRewardDao.commentByUser(recommendDTO.getUserAccountId(), recommendDTO.getIsEmployer() == 1));
        return result;
    }

    /**
     * 用户项目推荐项目统计-列表部分
     */
    @Override
    public  Page<HadRecommendReturnDTO>  recommendListByUser(RecommendSelectDTO recommendDTO) {
        Page<HadRecommendReturnDTO> hadRecommendReturnDTOPage = omsProjectRewardDao.recommendListByUser(recommendDTO);
        // 合并项目专员数据
        List<Map<String, Object>> speciaList = commentFeignAppManager.speciaList();
        Map<Long, String> speciaMap = new HashMap<Long, String>(speciaList.size());
        for (int i = 0; i < speciaList.size(); i++) {
            speciaMap.put(Long.valueOf(speciaList.get(i).get("id").toString()),
                    speciaList.get(i).get("name").toString());
        }
        for (HadRecommendReturnDTO project : hadRecommendReturnDTOPage.getData()) {
            project.setManagerName(speciaMap.get(project.getManagerId()));
        }
        return hadRecommendReturnDTOPage;
    }
    
    /**
     * 用户项目推荐项目统计-总数部分
     */
    @Override
    public Map<String, Object> recommendCountByUser(RecommendSelectDTO recommendDTO) {
        Map<String, Object> countResult = omsProjectRewardDao.recommendCountByUser(recommendDTO.getUserAccountId());       
        // 合并评价数据
        countResult.put("comment", omsProjectRewardDao.commentByUser(recommendDTO.getUserAccountId(), false));
        return countResult;
    }

    /**
     * 分页查询可推荐给用户的项目
     */
    @Override
    public Page<RecommendReturnDTO> canRecommendList(RecommendSelectDTO recommendDTO) {
        return omsProjectRewardDao.canRecommendList(recommendDTO);
    }

	@Override
	public List<Map<String, Object>> grow(Map<String, Object> params) {
		
		return null;
	}

}
