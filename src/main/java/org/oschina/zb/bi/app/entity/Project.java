package org.oschina.zb.bi.app.entity;

import java.util.Date;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 项目表
 * 
 * @author ljw
 */
@TableName(value = "project")
public class Project extends BaseModel {

    private static final long serialVersionUID = 6262200101720528913L;
    /**
     * 项目编号
     */
    @TableField("project_no_")
    private String projectNo;
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
     * 需求名称
     */
    @TableField("name_")
    private String name;
    /**
     * 项目图片地址
     */
    @TableField("image_path_")
    private String imagePath;
    /**
     * 项目需求描述 ID
     */
    @TableField("prd_id_")
    private Long prdId;
    /**
     * 预算最少多少钱
     */
    @TableField("budget_min_")
    private Long budgetMin;
    /**
     * 预算最多多少钱
     */
    @TableField("budget_max_")
    private Long budgetMax;
    /**
     * 周期天数,以天为单位,如果用户选择三个月,则转换为天数处理
     */
    @TableField("cycle_")
    private Integer cycle;
    /**
     * 项目周期显示名称，如用户选择的三个月，八个月等
     */
    @TableField("cycle_name_")
    private String cycleName;
    /**
     * 支付方式 1 一次性支付 2分阶段支付
     */
    @TableField("pay_type_")
    private Integer payType;
    /**
     * 是否倾向地域 1不限 2倾向
     */
    @TableField("is_tendency_district_")
    private Integer isTendencyDistrict;
    /**
     * 倾向接包省份
     */
    @TableField("tendency_province_")
    private String tendencyProvince;
    /**
     * 倾向接包市区
     */
    @TableField("tendency_city_")
    private String tendencyCity;
    /**
     * 倾向接包方类型, 1=不限、2=个人、3=企业、4团队
     */
    @TableField("tendency_type_")
    private Integer tendencyType;
    /**
     * 状态 1草稿 2待托管 3竞标中 4实施中 5已完成 6仲裁中 7 终止 8 关闭 9 已下架
     */
    @TableField("status_")
    private Integer status;
    /**
     * 状态最后时间
     */
    @TableField("status_last_time_")
    private Date statusLastTime;
    /**
     * 子状态 0默认 1待选标 2等待中标方确认 3合同待发送 4合同待接包方确认
     */
    @TableField("sub_status_")
    private Integer subStatus;
    /**
     * 发布时间
     */
    @TableField("publish_time_")
    private Date publishTime;
    /**
     * 托管保证金状态 1未托管 2已托管 默认1
     */
    @TableField("deposit_hosting_status_")
    private Integer depositHostingStatus;
    /**
     * 保证金托管金额
     */
    @TableField("deposit_money_")
    private Long depositMoney;
    /**
     * 联系信息编号
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
     * 查看次数
     */
    @TableField("view_count_")
    private Long viewCount;
    /**
     * 是否私有项目 1不是  2是
     */
    @TableField("visible_")
    private Integer visible;
    /**
     * 是否内部项目 1是 2不是 默认2
     */
    @TableField("is_internal_")
    private Integer isInternal;
    
    /**
     * 发布状态  1正常    2已下架  默认1
     */
    @TableField("publish_status_")
    private Short publishStatus;
    
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
    @TableField("handle_time_")
    private Date handleTime;

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
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

    public Long getBudgetMin() {
        return budgetMin;
    }

    public void setBudgetMin(Long budgetMin) {
        this.budgetMin = budgetMin;
    }

    public Long getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(Long budgetMax) {
        this.budgetMax = budgetMax;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getIsTendencyDistrict() {
        return isTendencyDistrict;
    }

    public void setIsTendencyDistrict(Integer isTendencyDistrict) {
        this.isTendencyDistrict = isTendencyDistrict;
    }

    public String getTendencyProvince() {
        return tendencyProvince;
    }

    public void setTendencyProvince(String tendencyProvince) {
        this.tendencyProvince = tendencyProvince;
    }

    public String getTendencyCity() {
        return tendencyCity;
    }

    public void setTendencyCity(String tendencyCity) {
        this.tendencyCity = tendencyCity;
    }

    public Integer getTendencyType() {
        return tendencyType;
    }

    public void setTendencyType(Integer tendencyType) {
        this.tendencyType = tendencyType;
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

    public Integer getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(Integer subStatus) {
        this.subStatus = subStatus;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getDepositHostingStatus() {
        return depositHostingStatus;
    }

    public void setDepositHostingStatus(Integer depositHostingStatus) {
        this.depositHostingStatus = depositHostingStatus;
    }

    public Long getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(Long depositMoney) {
        this.depositMoney = depositMoney;
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
