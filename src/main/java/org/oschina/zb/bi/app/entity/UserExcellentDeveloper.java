package org.oschina.zb.bi.app.entity;

import java.util.Date;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 优质开发商
 * 
 * @author ljw
 *
 */
@TableName("user_excellent_developer")
public class UserExcellentDeveloper extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -5031679054634005072L;
    /**
     * 用户账户ID
     */
    @TableField("user_account_id_")
    private Long userAccountId;
    /**
     * 等级Key
     */
    @TableField("level_key_")
    private String levelKey;
    /**
     * 等级名称
     */
    @TableField("level_name_")
    private String levelName;
    /**
     * 审核时间
     */
    @TableField("audit_time_")
    private Date auditTime;
    /**
     * 管理员ID（审核过程）
     */
    @TableField("audit_manager_id_")
    private Long auditManagerId;
    
    /**
     * 状态1申请2成功3拒绝4撤销
     */
    @TableField("status_")
    private Integer status;
    /**
     * 状态最后时间
     */
    @TableField("status_last_time_")
    private Date statusLastTime;
    

    public UserExcellentDeveloper() {
    }

    
    /**
     * 创建初始化
     */
    public void createInit(Long managerId) {
        setCreatedAt(new Date());
        setCreatedBy(managerId);
    }

    /**
     * 修改初始化
     */
    public void updateInit(Long managerId) {
        this.auditManagerId=managerId;
        setUpdatedAt(new Date());
        setUpdatedBy(managerId);
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
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

    public Long getAuditManagerId() {
        return auditManagerId;
    }

    public void setAuditManagerId(Long auditManagerId) {
        this.auditManagerId = auditManagerId;
    }

    public Date getStatusLastTime() {
        return statusLastTime;
    }

    public void setStatusLastTime(Date date) {
        this.statusLastTime = date;
    }
    
    
}
