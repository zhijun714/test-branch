package org.oschina.zb.bi.app.service.dto;

import java.util.Date;

/**
 * 推荐项目信息<br>
 * 为用户推荐项目时封装查询条件专用
 * 
 * @author ljw
 *
 */
public class RecommendSelectDTO {
    /**
     * 用户账户ID
     */
    private Long userAccountId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型1项目2悬赏
     */
    private Integer type;
    /**
     * 应用类型
     */
    private String application;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 是否已经竞标 1是2否
     */
    private Integer applyStatus;
    /**
     * 是否发包方1 是2 不是
     */
    private Integer isEmployer;
    /**
     * 编号
     */
    private String no;
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
     * 用户昵称
     */
    private String nickname;

    // 分页
    private Integer currentPage;
    private Integer pageSize;
    // 排序
    /**
     * 排序字段
     */
    private String sort;
    /**
     * 排序方式 ASC正序 DESC倒叙
     */
    private String dir;

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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Integer getIsEmployer() {
        return isEmployer;
    }

    public void setIsEmployer(Integer isEmployer) {
        this.isEmployer = isEmployer;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

}
