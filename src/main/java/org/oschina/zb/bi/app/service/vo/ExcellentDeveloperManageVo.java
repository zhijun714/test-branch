package org.oschina.zb.bi.app.service.vo;

public class ExcellentDeveloperManageVo {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 状态 1申请 2成功 3拒绝 4撤销
     */
    private Integer status;
    
    /**
     * 位置
     */
    private String location;
    /**
     * 等级key
     */
    private String levelKey;
    /**
     * 开始认证时间
     */
    private String beginAuditTime;
    /**
     * 结束认证时间
     */
    private String endAuditTime;
    /**
     * 综合评价
     */
    private Integer commentAvgScore;
    /**
     * 推荐项目数
     */
    private Integer recommendCount;
    /**
     * 推荐项目参与数
     */
    private Integer recommendApplyCount;
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
     * 产品 中间件
     */
    private String productMiddleware;
    /**
     * 可担任角色
     */
    private String role;
    /**
     * 是否推荐到微信 1是2不是
     */
    private Integer isRecommendToWeixin;
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页大小
     */
    private Integer pageSize;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevelKey() {
        return levelKey;
    }

    public void setLevelKey(String levelKey) {
        this.levelKey = levelKey;
    }

    public String getBeginAuditTime() {
        return beginAuditTime;
    }

    public void setBeginAuditTime(String beginAuditTime) {
        this.beginAuditTime = beginAuditTime;
    }

    public String getEndAuditTime() {
        return endAuditTime;
    }

    public void setEndAuditTime(String endAuditTime) {
        this.endAuditTime = endAuditTime;
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

    public Integer getRecommendApplyCount() {
        return recommendApplyCount;
    }

    public void setRecommendApplyCount(Integer recommendApplyCount) {
        this.recommendApplyCount = recommendApplyCount;
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

    public Integer getCommentAvgScore() {
        return commentAvgScore;
    }

    public void setCommentAvgScore(Integer commentAvgScore) {
        this.commentAvgScore = commentAvgScore;
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public Integer getIsRecommendToWeixin() {
        return isRecommendToWeixin;
    }

    public void setIsRecommendToWeixin(Integer isRecommendToWeixin) {
        this.isRecommendToWeixin = isRecommendToWeixin;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
