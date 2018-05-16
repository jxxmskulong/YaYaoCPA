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
 * 成功数据类
 * 
 * @author yy
 * 
 */
@ApiModel(value="成功数据",description="成功数据")
@Entity
@Table(name="success_data_tb",
		indexes={
		@Index(name="INDEX_CHANNELADVERTISEID",columnList = "channelAdvertiseId"),
		@Index(name="INDEX_STATUS",columnList = "status"),
		@Index(name="INDEX_CREATEDATE",columnList = "createDate"),
		@Index(name="INDEX_UPDATEDATE",columnList = "updateDate")
		})
public class SuccessData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 成功数据id
	 */
	@ApiModelProperty(value="成功数据id",example="成功数据id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer successDataId;
	/**
	 * 状态，0已失败，1已成功
	 */
	@ApiModelProperty(value="状态，0已失败，1已成功",example="状态，0已失败，1已成功")
	private String status;
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
	 * 渠道广告id
	 */
	@ApiModelProperty(value="渠道广告id",example="渠道广告id")
	private Integer channelAdvertiseId;
	/**
	 * 渠道广告
	 */
	@ApiModelProperty(value="渠道广告",example="渠道广告")
	@Transient
	private ChannelAdvertise channelAdvertise;
	public Integer getSuccessDataId() {
		return successDataId;
	}
	public void setSuccessDataId(Integer successDataId) {
		this.successDataId = successDataId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Integer getChannelAdvertiseId() {
		return channelAdvertiseId;
	}
	public void setChannelAdvertiseId(Integer channelAdvertiseId) {
		this.channelAdvertiseId = channelAdvertiseId;
	}
	public ChannelAdvertise getChannelAdvertise() {
		return channelAdvertise;
	}
	public void setChannelAdvertise(ChannelAdvertise channelAdvertise) {
		this.channelAdvertise = channelAdvertise;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
