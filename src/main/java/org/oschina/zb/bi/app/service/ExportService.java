package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

/**
 * 导出数据到文件
 * 
 * @author wjc
 *
 */

public interface ExportService {
    /**
     * 导出进账记录
     * 
     * @param params
     * @return
     */
    List<Object[]> revenue(Map<String, Object> params);

    /**
     * 导出出账记录
     * 
     * @param params
     * @return
     */
    List<Object[]> expenditure(Map<String, Object> params);

    /**
     * 导出项目列表
     * 
     * @param params
     * @return
     */
    List<Object[]> projectList(Map<String, Object> params);

    /**
     * 导出悬赏列表
     * 
     * @param params
     * @return
     */
    List<Object[]> rewardList(Map<String, Object> params);
}
