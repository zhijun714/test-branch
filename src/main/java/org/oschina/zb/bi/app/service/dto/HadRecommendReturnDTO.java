package org.oschina.zb.bi.app.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 已推荐项目信息<br>
 * 为用户已推荐项目时封装返回结果专用
 * 
 * @author ljw
 *
 */
public class HadRecommendReturnDTO {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型1项目2悬赏
     */
    private Integer type;
    /**
     * 是否报名
     */
    private Integer isApply;
    /**
     * 是否中标
     */
    private Integer isWinning;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createdAt;
    /**
     * 管理员ID
     */
    private Long managerId;
    /**
     * 管理员名称
     */
    private String managerName;
    /**
     * 应用领域
     */
    private String skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIsApply() {
        return isApply;
    }

    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    public Integer getIsWinning() {
        return isWinning;
    }

    public void setIsWinning(Integer isWinning) {
        this.isWinning = isWinning;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}
