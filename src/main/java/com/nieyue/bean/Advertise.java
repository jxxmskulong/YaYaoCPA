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
 * 广告
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="广告",description="广告")
@Entity
@Table(name="advertise_tb",
		indexes={
		@Index(name="INDEX_TYPE",columnList = "type"),
		@Index(name="INDEX_PRICE",columnList = "price"),
		@Index(name="INDEX_TASKNUM",columnList = "taskNum"),
		@Index(name="INDEX_ADVERTISEACCOUNTID",columnList = "advertiseAccountId"),
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer advertiseId;
	/**
	 * 平台1web，2android，3ios
	 */
	@ApiModelProperty(value="平台1web，2android，3ios",example="平台1web，2android，3ios")
	private Integer platform;
	/**
	 * 类型1注册，2充值
	 */
	@ApiModelProperty(value="类型1注册，2充值",example="类型1注册，2充值")
	private Integer type;
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
	 * 分成比例
	 */
	@ApiModelProperty(value="分成比例",example="分成比例")
	private Double proportion;
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
	 * 状态 1正常，2停用，3完成
	 */
	@ApiModelProperty(value="状态 1正常，2停用，3完成",example="状态 1正常，2停用，3完成")
	private Integer status;
	/**
	 * 广告账户id外键
	 */
	@ApiModelProperty(value="广告账户id外键",example="广告账户id外键")
	private Integer advertiseAccountId;
	/**
	 * 账户
	 */
	@ApiModelProperty(value="账户",example="账户")
	@Transient
	private Account advertiseAccount;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getAdvertiseAccountId() {
		return advertiseAccountId;
	}
	public void setAdvertiseAccountId(Integer advertiseAccountId) {
		this.advertiseAccountId = advertiseAccountId;
	}
	public Account getAdvertiseAccount() {
		return advertiseAccount;
	}
	public void setAdvertiseAccount(Account advertiseAccount) {
		this.advertiseAccount = advertiseAccount;
	}
	public Integer getPlatform() {
		return platform;
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getProportion() {
		return proportion;
	}
	public void setProportion(Double proportion) {
		this.proportion = proportion;
	}
}
