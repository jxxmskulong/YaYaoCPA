package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 广告
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="账户",description="账户")
@Entity
@Table(name="advertise_tb",
		indexes={
		@Index(name="INDEX_PRICE",columnList = "price"),
		@Index(name="INDEX_TASKNUM",columnList = "taskNum"),
		@Index(name="INDEX_ACCOUNTID",columnList = "accountId"),
		@Index(name="INDEX_STATUS",columnList = "status"),
		@Index(name="INDEX_CREATEDATE",columnList = "createDate"),
		@Index(name="INDEX_UPDATEDATE",columnList = "updateDate")
		})
public class Advertise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 广告id
	 */
	@ApiModelProperty(value="广告id",example="广告id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="increment")
	@SequenceGenerator(name = "increment",initialValue = 1000)
	private Integer advertiseId;
	/**
	 * 广告名称
	 */
	@ApiModelProperty(value="广告名称",example="广告名称")
	private String name;
	/**
	 * 包名bundleId
	 */
	@ApiModelProperty(value="包名bundleId",example="包名bundleId")
	private String bundleId;
	/**
	 * 任务要求
	 */
	@ApiModelProperty(value="任务要求",example="任务要求")
	private String taskDemands;
	/**
	 * 货币
	 */
	@ApiModelProperty(value="货币",example="货币")
	private String currency;
	/**
	 * 国家
	 */
	@ApiModelProperty(value="国家",example="国家")
	private String country;
	/**
	 * 图标
	 */
	@ApiModelProperty(value="图标",example="图标")
	private String icon;
	/**
	 * 价格
	 */
	@ApiModelProperty(value="价格",example="价格")
	private Double price;
	/**
	 * 投放链接
	 */
	@ApiModelProperty(value="投放链接",example="投放链接")
	private String url;
	/**
	 * 任务数量
	 */
	@ApiModelProperty(value="任务数量",example="任务数量")
	private Integer taskNum;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value="创建时间",example="创建时间")
	private Date createDate;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value="更新时间",example="更新时间")
	private Date updateDate;
	/**
	 * 状态 1是正常，2是停用
	 */
	@ApiModelProperty(value="状态 1是正常，2是停用",example="状态 1是正常，2是停用")
	private Integer status;
	/**
	 * 账户id外键
	 */
	@ApiModelProperty(value="账户id外键",example="账户id外键")
	private Integer accountId;
	/**
	 * 账户
	 */
	@ApiModelProperty(value="账户",example="账户")
	@Transient
	private Account account;
	public Integer getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBundleId() {
		return bundleId;
	}
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}
	public String getTaskDemands() {
		return taskDemands;
	}
	public void setTaskDemands(String taskDemands) {
		this.taskDemands = taskDemands;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTaskNum() {
		return taskNum;
	}
	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
