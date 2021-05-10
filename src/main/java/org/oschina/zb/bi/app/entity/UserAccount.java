package org.oschina.zb.bi.app.entity;

import org.oschina.zb.platform.core.base.BaseModel;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户账户ID，所有的业务都跟此表关联
 * </p>
 *
 * @author 众包平台研发中心
 * @since 2017-07-06
 */
@TableName("user_account")
public class UserAccount extends BaseModel {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户昵称
     */
    @TableField("nickname_")
    private String nickname;
    @TableField("name_")
    private String name;
    /**
     * 头像地址
     */
    @TableField("icon_path_")
    private String iconPath;
    /**
     * 认证状态, 1=未认证, 2=审核中, 3=通过, 4=未通过
     */
    @TableField("certification_status_")
    private Integer certificationStatus;
    /**
     * 所在省份
     */
    @TableField("province_")
    private String province;
    /**
     * 所在城市
     */
    @TableField("city_")
    private String city;
    /**
     * 所在区县
     */
    @TableField("county_")
    private String county;
    /**
     * 身份类型, 1=个人, 2=企业
     */
    @TableField("type_")
    private Integer type;
    /**
     * 是否发包方 1是 2不是
     */
    @TableField("is_employer_")
    private Integer isEmployer;
    /**
     * 是否接包方 1是 2不是
     */
    @TableField("is_contractor_")
    private Integer isContractor;
    /**
     * 账户状态, 1=正常, 2=冻结
     */
    @TableField("status_")
    private Integer status;

    

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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public Integer getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(Integer certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsEmployer() {
        return isEmployer;
    }

    public void setIsEmployer(Integer isEmployer) {
        this.isEmployer = isEmployer;
    }

    public Integer getIsContractor() {
        return isContractor;
    }

    public void setIsContractor(Integer isContractor) {
        this.isContractor = isContractor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}