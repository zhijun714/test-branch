package org.oschina.zb.bi.app.service.dto;

import java.util.Date;

public class ExcellentDeveloperManageDTO {

    /**
     * 优质开发商ID
     */
    private Long id;
    /**
     * 用户账户ID
     */
    private Long userAccountId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 姓名
     */
    private String name;
    /**
     * 所在位置
     */
    private String location;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 等级key
     */
    private String levelKey;
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 认证时间
     */
    private Date auditTime;
    /**
     * 综合评价分数
     */
    private Integer commentAvgScore;
    /**
     * 推荐数量
     */
    private Integer recommendCount;
    /**
     * 推荐参与数量
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
     * 开发 语言
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
     * 可承担角色
     */
    private String role;
    /**
     * 是否推荐到微信 1是2不是
     */
    private Integer isRecommendToWeixin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLevelKey() {
        return levelKey;
    }

    public void setLevelKey(String levelKey) {
        this.levelKey = levelKey;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
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

    public Integer getRecommendApplyCount() {
        return recommendApplyCount;
    }

    public void setRecommendApplyCount(Integer recommendApplyCount) {
        this.recommendApplyCount = recommendApplyCount;
    }

    public Integer getIsRecommendToWeixin() {
        return isRecommendToWeixin;
    }

    public void setIsRecommendToWeixin(Integer isRecommendToWeixin) {
        this.isRecommendToWeixin = isRecommendToWeixin;
    }

}
