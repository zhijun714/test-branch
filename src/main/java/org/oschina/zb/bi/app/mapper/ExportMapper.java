package org.oschina.zb.bi.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 导出到文件
 * 
 * @author wjc
 *
 */
@Mapper
public interface ExportMapper {
    /**
     * 进账记录
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> revenue(@Param("params") Map<String, Object> params);

    /**
     * 出账记录
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> expenditure(@Param("params") Map<String, Object> params);

    /**
     * 项目列表导出
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> projectList(@Param("params") Map<String, Object> params);

    /**
     * 悬赏列表导出
     * 
     * @param params
     * @return
     */
    List<Map<String, Object>> rewardList(@Param("params") Map<String, Object> params);
}
