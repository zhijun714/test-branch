package org.oschina.zb.bi.app.test.model;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("test_osc_users")
public class TestOscUsers extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableField("username_")
	private String username;
	
	@TableField("password_")
	private String password;

    @TableField("osc_id_")
	private Long oscId;
	
    @TableField("osc_id_cookie_")
	private String oscIdCookie;
	
    @TableField("nickname_")
	private String nickname;
	
    @TableField("icon_path_")
	private String iconPath;
	
    @TableField("mobile_")
	private String mobile;
	
    @TableField("email_")
	private String email;
	
    @TableField("province_")
	private String province;
	
    @TableField("city_")
	private String city;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOscId() {
		return oscId;
	}

	public String getOscIdCookie() {
		return oscIdCookie;
	}

	public String getNickname() {
		return nickname;
	}

	public String getIconPath() {
		return iconPath;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public void setOscId(Long oscId) {
		this.oscId = oscId;
	}

	public void setOscIdCookie(String oscIdCookie) {
		this.oscIdCookie = oscIdCookie;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
