package org.oschina.zb.bi.app.test.dao;

import java.util.List;

import org.oschina.zb.bi.app.test.mapper.TestOscUsersMapper;
import org.oschina.zb.bi.app.test.model.TestOscUsers;
import org.oschina.zb.platform.core.base.BaseDao;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

@Repository
public class TestOscUsersDao extends BaseDao<TestOscUsersMapper, TestOscUsers> {

	public TestOscUsers findByUsername(String username) {
		EntityWrapper<TestOscUsers> wrapper = new EntityWrapper<>();
		wrapper.eq("username_", username);
		
		List<TestOscUsers> list = selectList(wrapper);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	
	public TestOscUsers findByMobile(String mobile) {
		EntityWrapper<TestOscUsers> wrapper = new EntityWrapper<>();
		wrapper.eq("mobile_", mobile);
		
		List<TestOscUsers> list = selectList(wrapper);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	public TestOscUsers findByOscIdCookie(String oscIdCookie) {
		EntityWrapper<TestOscUsers> wrapper = new EntityWrapper<>();
		wrapper.eq("osc_id_cookie_", oscIdCookie);
		
		List<TestOscUsers> list = selectList(wrapper);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
