package org.oschina.zb.bi.app.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 推荐项目信息<br>
 * 为用户推荐项目时封装返回结果专用
 * 
 * @author ljw
 *
 */
public class RecommendReturnDTO {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 编号
     */
    private String no;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型1项目2悬赏
     */
    private Integer type;
    /**
     * 应用领域
     */
    private String applicationArea;
    /**
     * 项目类型
     */
    private String projectType;
    /**
     * 开发语言
     */
    private String developmentLanguage;
    /**
     * 开发技能
     */
    private String developmentSkills;
    /**
     * 产品中间件
     */
    private String productMiddleware;
    /**
     * 可担任角色
     */
    private String role;
    /**
     * 发布时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date publishTime;
    /**
     * 发包方昵称
     */
    private String nickname;
    
    /**
     * 用户竞标状态 1=已参与竞标 2=未竞标
     */
    private short applyStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDevelopmentLanguage() {
        return developmentLanguage;
    }

    public void setDevelopmentLanguage(String developmentLanguage) {
        this.developmentLanguage = developmentLanguage;
    }

    public String getDevelopmentSkills() {
        return developmentSkills;
    }

    public void setDevelopmentSkills(String developmentSkills) {
        this.developmentSkills = developmentSkills;
    }

    public String getProductMiddleware() {
        return productMiddleware;
    }

    public void setProductMiddleware(String productMiddleware) {
        this.productMiddleware = productMiddleware;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

	public short getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(short applyStatus) {
		this.applyStatus = applyStatus;
	}

}
