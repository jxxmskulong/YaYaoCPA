package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色
 * @author yy
 *
 */
@ApiModel(value="角色",description="角色")
@Entity
@Table(name="role_tb")
public class Role implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    @ApiModelProperty(value="角色id",example="角色id")
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="identity")
	@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
    private Integer roleId;

    /**
     * 角色名
     */
    @ApiModelProperty(value="角色名",example="角色名")
    private String name;
    /**
     * 角色职责
     */
    @ApiModelProperty(value="角色职责",example="角色职责")
    private String duty;
    /**
     * 角色更新时间
     */
    @ApiModelProperty(value="角色更新时间",example="角色更新时间")
    private Date updateDate;

    public Role(Integer roleId, String name, String duty, Date updateDate) {
        super();
        this.roleId = roleId;
        this.name = name;
        this.duty = duty;
        this.updateDate = updateDate;
    }
    public Role() {
        super();
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDuty() {
        return duty;
    }
    public void setDuty(String duty) {
        this.duty = duty;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", name=" + name + ", duty=" + duty + ", updateDate=" + updateDate + "]";
    }

}
