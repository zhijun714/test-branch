package org.oschina.zb.bi.app.service.dto;

import java.util.Date;

/**
 * 用户发布/承接项目/悬赏返回值DTO<br>
 * 查询用户发布/承接项目/悬赏专用
 * 
 * @author ljw
 *
 */
public class UserProjectReturnDTO {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 应用领域
     */
    private String skill;
    /**
     * 类型1项目2悬赏
     */
    private Integer type;
    /**
     * 赏金
     */
    private Integer budget;
    /**
     * 周期
     */
    private String cycle;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 报名状态
     */
    private String applyStatus;
    /**
     * 状态最后时间
     */
    private Date statusLastTime;

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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getStatusLastTime() {
        return statusLastTime;
    }

    public void setStatusLastTime(Date statusLastTime) {
        this.statusLastTime = statusLastTime;
    }

}
