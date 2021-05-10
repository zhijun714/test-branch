package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.RewardFinishDataDao;
import org.oschina.zb.platform.core.base.BaseService;

/**
 * 结项悬赏信息查询
 * 
 * @author ljw
 *
 */
public interface RewardFinishDataService extends BaseService<RewardFinishDataDao> {
    /**
     * 结项悬赏类型统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> type(Map<String, Object> params);

    /**
     * 结项悬赏进度统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> schedule(Map<String, Object> params);

    /**
     * 结项悬赏金额统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> money(Map<String, Object> params);

    /**
     * 结项悬赏平均值统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> average(Map<String, Object> params);

    /**
     * 结项悬赏评价统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> comment(Map<String, Object> params);

}
