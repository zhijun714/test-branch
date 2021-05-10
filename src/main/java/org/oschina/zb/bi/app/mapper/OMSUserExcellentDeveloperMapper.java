package org.oschina.zb.bi.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.oschina.zb.bi.app.entity.UserExcellentDeveloper;
import org.oschina.zb.bi.app.service.dto.ExcellentDeveloperManageDTO;
import org.oschina.zb.bi.app.service.vo.ExcellentDeveloperManageVo;
import org.oschina.zb.platform.core.base.BaseMapper;
import org.oschina.zb.platform.core.mybatis.Page;

/**
 * 优质开发商管理Mapper
 * 
 * @author ljw
 *
 */
@Mapper
public interface OMSUserExcellentDeveloperMapper extends BaseMapper<UserExcellentDeveloper> {
    /**
     * 优质开发商管理列表
     * 
     * @param manageVo
     * @param page
     * @return
     */
    List<ExcellentDeveloperManageDTO> manageList(@Param("manageVo") ExcellentDeveloperManageVo manageVo,
            @Param("page") Page<ExcellentDeveloperManageDTO> page);

}
