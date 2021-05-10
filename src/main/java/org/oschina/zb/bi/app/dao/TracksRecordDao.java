package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.constant.TrackRecordConstant;
import org.oschina.zb.bi.app.entity.CommUserBehaviorLog;
import org.oschina.zb.bi.app.mapper.TracksRecordMapper;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 跟踪记录统计Dao
 * 
 * @author ljw
 */
@Repository
public class TracksRecordDao extends BaseDao<TracksRecordMapper, CommUserBehaviorLog> {
    /**
     * 来源分析
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> sourceAnalysis(Map<String, Object> params) {        
        params.put("searchEngines", TrackRecordConstant.SEARCH_ENGINES);
        return mapper.sourceAnalysis(params);
    }
}
