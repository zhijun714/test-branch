package org.oschina.zb.bi.app.service.impl;

import java.util.Map;

import org.oschina.zb.bi.app.mapper.OtherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户数据统计
 * 
 * @author wjc
 *
 */
@Service
public class OtherServiceImpl {

	@Autowired
	OtherMapper otherMapper;
//	/**
//	 * 注册用户
//	 * @param params
//	 * @return
//	 */
//	public Map userAccountFindByName(String name){
//		return otherMapper.userAccountFindByName(name);
//	}
}
