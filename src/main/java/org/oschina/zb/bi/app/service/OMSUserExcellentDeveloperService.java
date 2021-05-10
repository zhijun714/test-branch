package org.oschina.zb.bi.app.service;

import org.oschina.zb.bi.app.dao.OMSUserExcellentDeveloperDao;
import org.oschina.zb.bi.app.service.dto.ExcellentDeveloperManageDTO;
import org.oschina.zb.bi.app.service.vo.ExcellentDeveloperManageVo;
import org.oschina.zb.platform.core.base.BaseService;
import org.oschina.zb.platform.core.mybatis.Page;
/**
 * 优质开发商管理Service
 * @author ljw
 *
 */
public interface OMSUserExcellentDeveloperService extends BaseService<OMSUserExcellentDeveloperDao>{
    /**
     * 优质开发商列表
     * @param manageVo
     * @return
     */
    Page<ExcellentDeveloperManageDTO> manageList(ExcellentDeveloperManageVo manageVo);

}
