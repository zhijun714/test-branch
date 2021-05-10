package org.oschina.zb.bi.app.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.constant.CommonConstant;
import org.oschina.zb.bi.app.constant.ProjectStatusConstant;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.bi.app.mapper.OMSProjectRewardMapper;
import org.oschina.zb.bi.app.service.dto.HadRecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendReturnDTO;
import org.oschina.zb.bi.app.service.dto.RecommendSelectDTO;
import org.oschina.zb.bi.app.service.dto.UserProjectReturnDTO;
import org.oschina.zb.platform.core.base.BaseDao;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.stereotype.Repository;

/**
 * 项目与悬赏合并Dao
 * 
 * @author ljw
 *
 */
@Repository
public class OMSProjectRewardDao extends BaseDao<OMSProjectRewardMapper, Project> {

    /**
     * 项目统计列表<br>
     * 发包方
     * 
     * @param recommendSelectDTO
     * @return
     */
    public Page<UserProjectReturnDTO> totalListByEmployer(RecommendSelectDTO recommendSelectDTO) {
        Page<UserProjectReturnDTO> page = new Page<UserProjectReturnDTO>(recommendSelectDTO.getCurrentPage(),
                recommendSelectDTO.getPageSize());
        page.setData(mapper.totalListByEmployer(recommendSelectDTO, page));
        return page;
    }

    /**
     * 项目统计总数<br>
     * 发包方
     * 
     * @param userAccountId
     * @return
     */
    public Map<String, Object> totalCountByEmployer(Long userAccountId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userAccountId", userAccountId);
        Map<String, Object> result = mapper.totalCountByEmployer(params).get(0);
        result.put("published",
                Integer.parseInt(result.get("bid").toString()) + Integer.parseInt(result.get("implement").toString())
                        + Integer.parseInt(result.get("completed").toString())
                        + Integer.parseInt(result.get("close").toString()));
        return result;
    }

    /**
     * 项目统计列表<br>
     * 接包方
     * 
     * @param recommendSelectDTO
     * @return
     */
    public Page<UserProjectReturnDTO> totalListByContractor(RecommendSelectDTO recommendSelectDTO) {
        Page<UserProjectReturnDTO> page = new Page<UserProjectReturnDTO>(recommendSelectDTO.getCurrentPage(),
                recommendSelectDTO.getPageSize());
        page.setData(mapper.totalListByContractor(recommendSelectDTO, page));
        return page;
    }

    /**
     * 项目统计总数<br>
     * 接包方
     * 
     * @param userAccountId
     * @return
     */
    public Map<String, Object> totalCountByContractor(Long userAccountId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userAccountId", userAccountId);
        List<Map<String, Object>> list = mapper.totalCountByContractor(params);
        return list.get(0);
    }

    /**
     * 项目统计评价部分- <br>
     * 接包方发包方通用查询
     * 
     * @param userAccountId
     * @return
     */
    public String commentByUser(Long userAccountId, boolean isEmployer) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userAccountId", userAccountId);
        params.put("isEmployer", isEmployer);
        List<Map<String, Object>> list = mapper.commentByUser(params);
        Map<String, Object> result = list.isEmpty() ? new HashMap<>() : list.get(0);
        return result.get("comment") == null ? "-" : result.get("comment").toString();
    }

    /**
     * 用户已推荐项目 <br>
     * 列表部分
     * 
     * @param userAccountId
     * @return
     */
    public Page<HadRecommendReturnDTO> recommendListByUser(RecommendSelectDTO recommendSelectDTO) {
        Page<HadRecommendReturnDTO> page = new Page<HadRecommendReturnDTO>(recommendSelectDTO.getCurrentPage(),
                recommendSelectDTO.getPageSize());
        page.setData(mapper.recommendListByUser(recommendSelectDTO, page));
        return page;
    }

    /**
     * 用户已推荐项目 <br>
     * 总数部分
     * 
     * @param userAccountId
     * @return
     */
    public Map<String, Object> recommendCountByUser(Long userAccountId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userAccountId", userAccountId);
        List<Map<String, Object>> list = mapper.recommendCountByUser(params);
        return list.get(0);
    }

    /**
     * 分页查询可推荐给用户的项目
     * 
     * @param paramDTO
     * @return
     */
    public Page<RecommendReturnDTO> canRecommendList(RecommendSelectDTO recommendSelectDTO) {
        Page<RecommendReturnDTO> page = new Page<RecommendReturnDTO>(recommendSelectDTO.getCurrentPage(),
                recommendSelectDTO.getPageSize());
        List<RecommendReturnDTO> list = mapper.canRecommendList(recommendSelectDTO, page);
        list.forEach(p -> {
    		int bizType = p.getType();
    		int count = 0;
    		if(bizType == CommonConstant.BIZ_TYPE_PROJECT){
    			count = mapper.checkApplyProject(recommendSelectDTO.getUserAccountId(), p.getId());
    		}else{
    			count = mapper.checkApplyReward(recommendSelectDTO.getUserAccountId(), p.getId());
    		}
    		short applyStatus = count > 0 ? ProjectStatusConstant.APPLY_STATUS_YES : ProjectStatusConstant.APPLY_STATUS_NO;
    		p.setApplyStatus(applyStatus);
    	});
        //条件查询过滤
//        Integer applyStatus = recommendSelectDTO.getApplyStatus();
//        if(applyStatus != null){
//        	Iterator<RecommendReturnDTO> iterator = list.iterator();
//        	while(iterator.hasNext()){
//        		if(applyStatus != iterator.next().getApplyStatus()){
//        			iterator.remove();
//        		}
//        	}
//        	page.setTotalCount(list.size());
//        }
        page.setData(list);
        return page;
    }
    
}
