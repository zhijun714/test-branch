package org.oschina.zb.bi.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.oschina.zb.bi.app.entity.Project;
import org.oschina.zb.platform.core.base.BaseMapper;

/**
 * 项目信息查询
 * 
 * @author ljw
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
}
