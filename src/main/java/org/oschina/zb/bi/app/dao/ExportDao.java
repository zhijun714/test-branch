package org.oschina.zb.bi.app.dao;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.mapper.ExportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 导出数据到文件
 * 
 * @author wjc
 *
 */
@Repository
public class ExportDao {

    @Autowired
    ExportMapper revenueMapper;

    /**
     * 导出进账记录
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> revenue(Map<String, Object> params) {
        return revenueMapper.revenue(params);
    }

    /**
     * 导出出账记录
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> expenditure(Map<String, Object> params) {
        return revenueMapper.expenditure(params);
    }

    /**
     * 导出项目列表
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> projectList(Map<String, Object> params) {
        return revenueMapper.projectList(params);
    }

    /**
     * 导出悬赏列表
     * 
     * @param params
     * @return
     */
    public List<Map<String, Object>> rewardList(Map<String, Object> params) {
        return revenueMapper.rewardList(params);
    }
}
