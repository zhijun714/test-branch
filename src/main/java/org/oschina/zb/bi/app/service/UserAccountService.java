package org.oschina.zb.bi.app.service;

import java.util.List;
import java.util.Map;

import org.oschina.zb.bi.app.dao.UserAccountDao;
import org.oschina.zb.platform.core.base.BaseService;
import org.oschina.zb.platform.core.mybatis.Page;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */

public interface UserAccountService extends BaseService<UserAccountDao> {

    /**
     * 注册用户
     * @param params
     * @return
     */
    Page userInfo(Map<String, Object> params,Page page);


    Page contractIssuing(Map<String, Object> params, Page page);

    Page contractReceiver(Map<String, Object> params, Page page);

    Page contractReceiverSearch(Map<String, Object> params, Page page);
    /**
     * 用户数据总览
     * 
     * @return
     */
    Map<String, Object> overview(Map<String, Object> params);

    /**
     * 新增用户统计
     * 
     * @param
     * @return
     */
    List<Map<String, Object>> newUser(Map<String, Object> params);

    /**
     * 用户增长趋势统计
     * 
     * @param params
     * @return
     */
    Map<String, Object> grow(Map<String, Object> params);
}
