package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.RewardGMVDao;
import org.oschina.zb.platform.core.base.BaseService;

/**
 * 悬赏GMVService
 * 
 * @author ljw
 */
public interface RewardGMVService extends BaseService<RewardGMVDao> {
    /**
     * 平台交易额统计
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> transaction(Map<String, Object> params);

}