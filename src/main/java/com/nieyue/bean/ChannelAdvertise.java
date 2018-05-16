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
 * 渠道广告
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="渠道广告",description="渠道广告")
@Entity
@Table(name="channel_advertise_tb",
		indexes={
		@Index(name="INDEX_STATUS",columnList = "status"),
		@Index(name="INDEX_ADVERTISEID",columnList = "advertiseId"),
		@Index(name="INDEX_CHANNELACCOUNTID",columnList = "channelAccountId"),
		@Index(name="INDEX_CREATEDATE",columnList = "createDate"),
		@Index(name="INDEX_UPDATEDATE",columnList = "updateDate")
		})
public class ChannelAdvertise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 渠道广告id
	 */
	@ApiModelProperty(value="渠道广告id",example="渠道广告id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer channelAdvertiseId;
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
	 * 完成数量
	 */
	@ApiModelProperty(value="完成数量",example="完成数量")
	private Integer number;
	/**
	 * ip数量
	 */
	@ApiModelProperty(value="ip数量",example="ip数量")
	private Integer ip;
	/**
	 * 收益
	 */
	@ApiModelProperty(value="收益",example="收益")
	private Double profit;
	/**
	 * 广告id外键
	 */
	@ApiModelProperty(value="广告id外键",example="广告id外键")
	private Integer advertiseId;
	/**
	 * 广告
	 */
	@ApiModelProperty(value="广告",example="广告")
	@Transient
	private Advertise advertise;
	/**
	 * 渠道账户id外键
	 */
	@ApiModelProperty(value="渠道账户id外键",example="渠道账户id外键")
	private Integer channelAccountId;
	/**
	 * 账户
	 */
	@ApiModelProperty(value="渠道账户",example="渠道账户")
	@Transient
	private Account channelAccount;
	public Integer getChannelAdvertiseId() {
		return channelAdvertiseId;
	}
	public void setChannelAdvertiseId(Integer channelAdvertiseId) {
		this.channelAdvertiseId = channelAdvertiseId;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}
	public Integer getChannelAccountId() {
		return channelAccountId;
	}
	public void setChannelAccountId(Integer channelAccountId) {
		this.channelAccountId = channelAccountId;
	}
	public Account getChannelAccount() {
		return channelAccount;
	}
	public void setChannelAccount(Account channelAccount) {
		this.channelAccount = channelAccount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Advertise getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	public Integer getIp() {
		return ip;
	}
	public void setIp(Integer ip) {
		this.ip = ip;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
}
