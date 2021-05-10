package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.CommUserBehaviorLog;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 跟踪记录统计Mapper
 * 
 * @author ljw
 *
 */
@Mapper
public interface TracksRecordMapper extends BaseMapper<CommUserBehaviorLog> {

    /**
     * 来源分析
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> sourceAnalysis(@Param("params") Map<String, Object> params);

}
