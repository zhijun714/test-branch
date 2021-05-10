package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.ProjectGMVDao;
import org.oschina.zb.platform.core.base.BaseService;

/**
 * 
 * 项目GMSService
 * 
 * @author ljw
 */
public interface ProjectGMVService extends BaseService<ProjectGMVDao> {

    /**
     * 平台交易额统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transaction(Map<String, Object> params);

}
