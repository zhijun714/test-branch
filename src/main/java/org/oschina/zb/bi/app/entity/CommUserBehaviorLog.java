package org.oschina.zb.bi.app.entity;

import java.util.Date;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("comm_user_behavior_log")
public class CommUserBehaviorLog extends BaseModel {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7810305176648410690L;

	/**
	 * 用户id
	 */
	@TableField("uid_")
	private Long uid;

	/**
	 * 用户账户id
	 */
	@TableField("uaid_")
	private Long uaid;

	/**
	 * 用户角色<br>
	 * 1=接包方<br>
	 * 2=发包方
	 */
	@TableField("ro_")
	private Integer ro;

	/**
	 * 来源(层次定位)
	 */
	@TableField("spm_")
	private String spm;

	/**
	 * referer url
	 */
	@TableField("rurl")
	private String rurl;

	/**
	 * 当前页面(层次定位)
	 */
	@TableField("cpm_")
	private String cpm;

	/**
	 * 当前页面url
	 */
	@TableField("curl_")
	private String curl;

	/**
	 * ip地址
	 */
	@TableField("ip_")
	private String ip;

	/**
	 * User Agent
	 */
	@TableField("ua_")
	private String ua;

	/**
	 * 平台<br>
	 * 1=pc网站<br>
	 * 2=移动端网站<br>
	 * 3=微信<br>
	 * 4=android(app)<br>
	 * 5=ios(app)<br>
	 */
	@TableField("pl_")
	private Integer pl;

	/**
	 * 操作系统<br>
	 * windows<br>
	 * mac<br>
	 * linux<br>
	 * android<br>
	 * ios<br>
	 */
	@TableField("os_")
	private String os;

	/**
	 * 行为类别<br>
	 * 1=页面跳转<br>
	 * 2=局部事件
	 */
	@TableField("bt_")
	private Integer bt;

	/**
	 * sessionId
	 */
	@TableField("sid_")
	private String sid;

	/**
	 * 操作时间
	 */
	@TableField("ltime_")
	private Date ltime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getUaid() {
		return uaid;
	}

	public void setUaid(Long uaid) {
		this.uaid = uaid;
	}

	public Integer getRo() {
		return ro;
	}

	public void setRo(Integer ro) {
		this.ro = ro;
	}

	public String getSpm() {
		return spm;
	}

	public String getCpm() {
		return cpm;
	}

	public void setCpm(String cpm) {
		this.cpm = cpm;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public Integer getPl() {
		return pl;
	}

	public void setPl(Integer pl) {
		this.pl = pl;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Integer getBt() {
		return bt;
	}

	public void setBt(Integer bt) {
		this.bt = bt;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Date getLtime() {
		return ltime;
	}

	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}

	public void setSpm(String spm) {
		this.spm = spm;
	}

	public String getRurl() {
		return rurl;
	}

	public void setRurl(String rurl) {
		this.rurl = rurl;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}
}
