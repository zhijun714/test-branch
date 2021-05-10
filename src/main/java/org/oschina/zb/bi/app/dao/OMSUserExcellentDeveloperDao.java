package org.oschina.zb.bi.app.dao;

import org.oschina.zb.bi.app.entity.UserExcellentDeveloper;
import org.oschina.zb.bi.app.mapper.OMSUserExcellentDeveloperMapper;
import org.oschina.zb.bi.app.service.dto.ExcellentDeveloperManageDTO;
import org.oschina.zb.bi.app.service.vo.ExcellentDeveloperManageVo;
import org.oschina.zb.platform.core.base.BaseDao;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.stereotype.Repository;

/**
 * 优质开发商管理
 * 
 * @author ljw
 *
 */
@Repository
public class OMSUserExcellentDeveloperDao extends BaseDao<OMSUserExcellentDeveloperMapper, UserExcellentDeveloper> {
    /**
     * 优质开发商管理列表
     * 
     * @param manageVo
     * @param page
     * @return
     */
    public Page<ExcellentDeveloperManageDTO> manageList(ExcellentDeveloperManageVo manageVo,
            Page<ExcellentDeveloperManageDTO> page) {
        page.setData(mapper.manageList(manageVo, page));
        return page;
    }

}
