package org.oschina.zb.bi.app.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.oschina.zb.bi.app.test.dao.TestOscUsersDao;
import org.oschina.zb.bi.app.test.model.TestOscUsers;
import org.oschina.zb.platform.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.toolkit.StringUtils;

@RestController
@RequestMapping("/action/apiv2/")
public class TestOscUsersController extends BaseController {

	@Autowired
	TestOscUsersDao dao;
	
    @PostMapping("/zb_login")
    public TestInvokeResponse<Object> zbLogin(
	    		@RequestParam("username")String username, 
	    		@RequestParam("password")String password) {
    	TestOscUsers user = dao.findByMobile(username);
    	if (user!=null && password.equals(user.getPassword())) {
    		return TestInvokeResponse.success(user); // 因社区1是成功   0是失败，所以这儿成功要用失败的方式
    	} else {
    		System.out.println(JSON.toJSONString(TestInvokeResponse.error("用户名或密码错误")));
    		return TestInvokeResponse.error("用户名或密码错误");
    	}
    }
    
    @PostMapping("/zb_register")
    public TestInvokeResponse<Object> zbRegister(TestOscUsers
    		user) {
    	if (user!=null && StringUtils.isNotEmpty(user.getMobile()) && StringUtils.isNotEmpty(user.getPassword())) {
    		if (null!=dao.findByMobile(user.getMobile())) {
    			return TestInvokeResponse.error("系统错误(该手机号已被注册！)"); 
    		}
    		
    		user.setOscIdCookie(UUID.randomUUID().toString().replaceAll("-", ""));
    		user.setOscId(System.currentTimeMillis()%100000000);
    		dao.insert(user);
    		
    		return TestInvokeResponse.success(user); // 因社区1是成功   0是失败，所以这儿成功要用失败的方式
    	}
    	return TestInvokeResponse.error();
    }
    
    
    @PostMapping("/zb_check_phone")
    public TestInvokeResponse<Object> zbCheckPhone(TestOscUsers
    		user) {
    	if (user!=null && StringUtils.isNotEmpty(user.getMobile())) {
    		if (null!=dao.findByMobile(user.getMobile())) {
    			return TestInvokeResponse.error("该手机号已被注册！"); 
    		}
    	}
    	return TestInvokeResponse.success();
    }
    
    @GetMapping("/check_user_login")
    public TestInvokeResponse<Object> checkUserLogin() {
    	Cookie cookie = getCookieByName(getRequest(), "oscId");
    	if (null!=cookie) {
    		TestOscUsers user = dao.findByOscIdCookie(cookie.getValue());
    		if (user!=null) {
    			return TestInvokeResponse.success(user);
    		}
    	}
    	
    	return TestInvokeResponse.error();
    }
    
    /**
     * 根据名字获取cookie
     * 
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     * 
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
