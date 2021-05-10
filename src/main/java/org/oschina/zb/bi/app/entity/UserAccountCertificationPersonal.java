package org.oschina.zb.bi.app.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.oschina.zb.platform.core.base.BaseModel;

/**
 * <p>
 * 存储网站个人用户实名认证信息
 * </p>
 *
 * @author 众包平台研发中心
 * @since 2017-07-06
 */
@TableName("user_account_certification_personal")
public class UserAccountCertificationPersonal extends BaseModel {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户账户ID
     */
    @TableField("user_account_id_")
    private Long userAccountId;
    /**
     * 真实姓名
     */
    @TableField("name_")
    private String name;
    /**
     * 身份证号
     */
    @TableField("id_card_num_")
    private String idCardNum;
    /**
     * 正面照片
     */
    @TableField("id_card_front_photo_path_")
    private String idCardFrontPhotoPath;
    /**
     * 背面照片
     */
    @TableField("id_card_back_photo_path_")
    private String idCardBackPhotoPath;
    /**
     * 手持证件照片
     */
    @TableField("id_card_hold_photo_path_")
    private String idCardHoldPhotoPath;
    /**
     * 身份证有效期, 记录用户身份证件的有效截至日期, 用于系统检测身份认证是否过期并提醒.
     */
    @TableField("expire_date_")
    private Date expireDate;
    /**
     * 是否过期, 计算身份证有效截至日期, 并标识出是否过期. 1 未过期, 2 已过期
     */
    @TableField("is_expires_")
    private Integer isExpires;
    /**
     * 申请时间，每次提交信息更新时都变更下此时间
     */
    @TableField("apply_time_")
    private Date applyTime;
    /**
     * 审核人
     */
    @TableField("auditor_id_")
    private Long auditorId;
    /**
     * 审核时间
     */
    @TableField("audit_time_")
    private Date auditTime;
    /**
     * 审核状态, 1 待审核, 2 审核通过, 3 审核未通过
     */
    @TableField("audit_status_")
    private Integer auditStatus;
    /**
     * 审核方式 1人工审核 2支付宝接口... 默认1
     */
    @TableField("audit_type_")
    private Integer auditType;

    
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

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getIdCardFrontPhotoPath() {
        return idCardFrontPhotoPath;
    }

    public void setIdCardFrontPhotoPath(String idCardFrontPhotoPath) {
        this.idCardFrontPhotoPath = idCardFrontPhotoPath;
    }

    public String getIdCardBackPhotoPath() {
        return idCardBackPhotoPath;
    }

    public void setIdCardBackPhotoPath(String idCardBackPhotoPath) {
        this.idCardBackPhotoPath = idCardBackPhotoPath;
    }

    public String getIdCardHoldPhotoPath() {
        return idCardHoldPhotoPath;
    }

    public void setIdCardHoldPhotoPath(String idCardHoldPhotoPath) {
        this.idCardHoldPhotoPath = idCardHoldPhotoPath;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getIsExpires() {
        return isExpires;
    }

    public void setIsExpires(Integer isExpires) {
        this.isExpires = isExpires;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

}
