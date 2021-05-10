package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.ProjectFinishDataDao;
import org.oschina.zb.platform.core.base.BaseService;

/**
 * 结赏项目信息查询Service
 * 
 * @author ljw
 *
 */
public interface ProjectFinishDataService extends BaseService<ProjectFinishDataDao> {
    /**
     * 结项项目类型统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> type(Map<String, Object> params);

    /**
     * 结项项目进度统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> schedule(Map<String, Object> params);

    /**
     * 结项项目平均值统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> average(Map<String, Object> params);

    /**
     * 结项项目金额统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> money(Map<String, Object> params);

    /**
     * 结项项目评价统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> comment(Map<String, Object> params);
}
