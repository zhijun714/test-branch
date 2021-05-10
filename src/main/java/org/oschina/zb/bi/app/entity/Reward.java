package org.oschina.zb.bi.app.entity;

import java.util.Date;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 悬赏表
 * 
 * @author ljw
 */
public class Reward extends BaseModel {

    private static final long serialVersionUID = 2818535777814490100L;
    /**
     * 悬赏编号
     */
    @TableField("reward_no_")
    private String rewardNo;
    /**
     * 发布人ID
     */
    @TableField("user_id_")
    private Long userId;
    /**
     * 发布帐户ID
     */
    @TableField("user_account_id_")
    private Long userAccountId;
    /**
     * 悬赏名称
     */
    @TableField("name_")
    private String name;
    /**
     * 悬赏图片地址
     */
    @TableField("image_path_")
    private String imagePath;
    /**
     * 悬赏描述ID
     */
    @TableField("prd_id_")
    private Long prdId;
    /**
     * 期望工期
     */
    @TableField("expected_duration_")
    private Integer expectedDuration;
    /**
     * 赏金
     */
    @TableField("bounty_")
    private Long bounty;
    /**
     * 状态 1草稿 2待托管(发布后) 3进行中 4已完成 6仲裁中 7已下架 8 已关闭
     */
    @TableField("status_")
    private Integer status;
    /**
     * 状态最后时间
     */
    @TableField("status_last_time_")
    private Date statusLastTime;
    /**
     * 发布时间
     */
    @TableField("publish_time_")
    private Date publishTime;
    /**
     * 托管赏金状态 1未托管 2已托管 默认1
     */
    @TableField("bounty_hosting_status_")
    private Integer bountyHostingStatus;
    /**
     * 托管时间
     */
    @TableField("bounty_hosting_time_")
    private Date bountyHostingTime;
    /**
     * 联系信息ID
     */
    @TableField("contact_id_")
    private Long contactId;
    /**
     * 附件可见性 1可见 2报名可见 默认1
     */
    @TableField("attachment_visible_")
    private Integer attachmentVisible;
    /**
     * 附件数量
     */
    @TableField("attachment_count_")
    private Integer attachmentCount;
    /**
     * 报名人数
     */
    @TableField("apply_count_")
    private Integer applyCount;
    /**
     * 方案提交数
     */
    @TableField("apply_scheme_count_")
    private Integer applySchemeCount;
    /**
     * 查看次数
     */
    @TableField("view_count_")
    private Long viewCount;
    /**
     * 是否主站显示 1显示 2不显示
     */
    @TableField("visible_")
    private Integer visible;
    /**
     * 是否内部项目 1是 2不是 默认2
     */
    @TableField("is_internal_")
    private Integer isInternal;
    /**
     * 项目专员ID
     */
    @TableField("specialist_id_")
    private Long specialistId;
    /**
     * 受理状态 1未受理 2已受理
     */
    @TableField("handle_status_")
    private Integer handleStatus;

    /**
     * 发布状态 1正常 2已下架
     */
    @TableField("publish_status_")
    private Short publishStatus;
    /**
     * 受理时间
     */
    @TableField("handle_time_")
    private Date handleTime;

    public String getRewardNo() {
        return rewardNo;
    }

    public void setRewardNo(String rewardNo) {
        this.rewardNo = rewardNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public Integer getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(Integer expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public Long getBounty() {
        return bounty;
    }

    public void setBounty(Long bounty) {
        this.bounty = bounty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStatusLastTime() {
        return statusLastTime;
    }

    public void setStatusLastTime(Date statusLastTime) {
        this.statusLastTime = statusLastTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBountyHostingStatus() {
        return bountyHostingStatus;
    }

    public void setBountyHostingStatus(Integer bountyHostingStatus) {
        this.bountyHostingStatus = bountyHostingStatus;
    }

    public Date getBountyHostingTime() {
        return bountyHostingTime;
    }

    public void setBountyHostingTime(Date bountyHostingTime) {
        this.bountyHostingTime = bountyHostingTime;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Integer getAttachmentVisible() {
        return attachmentVisible;
    }

    public void setAttachmentVisible(Integer attachmentVisible) {
        this.attachmentVisible = attachmentVisible;
    }

    public Integer getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getApplySchemeCount() {
        return applySchemeCount;
    }

    public void setApplySchemeCount(Integer applySchemeCount) {
        this.applySchemeCount = applySchemeCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Integer isInternal) {
        this.isInternal = isInternal;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Short getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Short publishStatus) {
        this.publishStatus = publishStatus;
    }

}