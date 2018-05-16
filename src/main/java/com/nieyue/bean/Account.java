package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 账户
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="账户",description="账户")
@Entity
@Table(name="account_tb",
		indexes={
		@Index(name="INDEX_AUTH",columnList = "auth"),
		@Index(name="INDEX_PHONE",columnList = "phone"),
		@Index(name="INDEX_REALNAME",columnList = "realname"),
		@Index(name="INDEX_CREATEDATE",columnList = "createDate"),
		@Index(name="INDEX_LOGINDATE",columnList = "loginDate"),
		@Index(name="INDEX_ROLEID",columnList = "roleId"),
		@Index(name="INDEX_STATUS",columnList = "status")
		})
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 账户id
	 */
	@ApiModelProperty(value="账户id",example="账户id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer accountId;
	/**
	 * 注册手机号
	 */
	@ApiModelProperty(value="注册手机号",example="注册手机号")
	private String phone;
	/**
	 * 密码
	 */
	@ApiModelProperty(value="密码",example="密码")
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(value="昵称",example="昵称")
	private String nickname;
	/**
	 * 图像
	 */
	@ApiModelProperty(value="图像",example="图像")
	private String icon;
	/**
	 * 性别,默认为0未知，为1男性，为2女性
	 */
	@ApiModelProperty(value="性别,默认为0未知，为1男性，为2女性",example="性别,默认为0未知，为1男性，为2女性")
	private Integer sex;
	/**
	 * 真实姓名
	 */
	@ApiModelProperty(value="真实姓名",example="真实姓名")
	private String realname;
	/**
	 * email
	 */
	@ApiModelProperty(value="email",example="email")
	private String email;
	/**
	 * 国家
	 */
	@ApiModelProperty(value="国家",example="国家")
	private String country;
	/**
	 * 认证，0没认证，1审核中，2已认证
	 */
	@ApiModelProperty(value="认证，0没认证，1审核中，2已认证",example="认证，0没认证，1审核中，2已认证")
	private Integer auth;
	/**
	 * 身份证
	 */
	@ApiModelProperty(value="身份证",example="身份证")
	private String identityCards;
	/**
	 * 手持身份证上半身照
	 */
	@ApiModelProperty(value="手持身份证上半身照",example="手持身份证上半身照")
	private String identityCardsHoldImg;
	/**
	 * 身份证正面
	 */
	@ApiModelProperty(value="身份证正面",example="身份证正面")
	private String identityCardsFrontImg;
	/**
	 * 身份证反面
	 */
	@ApiModelProperty(value="身份证反面",example="身份证反面")
	private String identityCardsBackImg;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间",example="创建时间")
	private Date createDate;
	/**
	 * 登陆时间
	 */
	@ApiModelProperty(value="登陆时间",example="登陆时间")
	private Date loginDate;
	/**
	 * 状态 0是正常，1是锁定，2是异常
	 */
	@ApiModelProperty(value="状态 0是正常，1是锁定，2是异常",example="状态 0是正常，1是锁定，2是异常")
	private Integer status;
	/**
	 * 角色id外键
	 */
	@ApiModelProperty(value="角色id外键",example="角色id外键")
	private Integer roleId;
	/**
	 * 角色
	 */
	@ApiModelProperty(value="角色",example="角色")
	@Transient
	private Role role;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getAuth() {
		return auth;
	}
	public void setAuth(Integer auth) {
		this.auth = auth;
	}
	public String getIdentityCards() {
		return identityCards;
	}
	public void setIdentityCards(String identityCards) {
		this.identityCards = identityCards;
	}
	public String getIdentityCardsHoldImg() {
		return identityCardsHoldImg;
	}
	public void setIdentityCardsHoldImg(String identityCardsHoldImg) {
		this.identityCardsHoldImg = identityCardsHoldImg;
	}
	public String getIdentityCardsFrontImg() {
		return identityCardsFrontImg;
	}
	public void setIdentityCardsFrontImg(String identityCardsFrontImg) {
		this.identityCardsFrontImg = identityCardsFrontImg;
	}
	public String getIdentityCardsBackImg() {
		return identityCardsBackImg;
	}
	public void setIdentityCardsBackImg(String identityCardsBackImg) {
		this.identityCardsBackImg = identityCardsBackImg;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
