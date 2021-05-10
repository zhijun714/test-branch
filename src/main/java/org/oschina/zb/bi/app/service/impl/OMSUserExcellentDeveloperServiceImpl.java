package org.oschina.zb.bi.app.service.impl;

import org.oschina.zb.bi.app.dao.OMSUserExcellentDeveloperDao;
import org.oschina.zb.bi.app.service.OMSUserExcellentDeveloperService;
import org.oschina.zb.bi.app.service.dto.ExcellentDeveloperManageDTO;
import org.oschina.zb.bi.app.service.vo.ExcellentDeveloperManageVo;
import org.oschina.zb.platform.core.base.BaseServiceImpl;
import org.oschina.zb.platform.core.mybatis.Page;
import org.springframework.stereotype.Service;

/**
 * 优质开发商管理
 * 
 * @author ljw
 *
 */
@Service
public class OMSUserExcellentDeveloperServiceImpl extends BaseServiceImpl<OMSUserExcellentDeveloperDao>
        implements OMSUserExcellentDeveloperService {
    /**
     * 优质开发商列表
     */
    @Override
    public Page<ExcellentDeveloperManageDTO> manageList(ExcellentDeveloperManageVo manageVo) {
        Page<ExcellentDeveloperManageDTO> page = new Page<>();
        page.setCurrentPage(manageVo.getCurrentPage() == null ? 1 : manageVo.getCurrentPage());
        page.setPageSize(manageVo.getPageSize() == null ? 10 : manageVo.getPageSize());
        page = dao.manageList(manageVo, page);
        return page;
    }

}
