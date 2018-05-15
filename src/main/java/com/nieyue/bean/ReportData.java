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
 * 上报数据类
 * 
 * @author yy
 * 
 */
@ApiModel(value="上报数据",description="上报数据")
@Entity
@Table(name="report_data_tb",
		indexes={
		@Index(name="INDEX_CHANNELADVERTISEID",columnList = "channelAdvertiseId"),
		@Index(name="INDEX_STATUS",columnList = "status"),
		@Index(name="INDEX_CREATEDATE",columnList = "createDate"),
		@Index(name="INDEX_UPDATEDATE",columnList = "updateDate")
		})
public class ReportData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 上报数据id
	 */
	@ApiModelProperty(value="上报数据id",example="上报数据id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="identity")
	@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer reportDataId;
	/**
	 * 广告标示符
	 */
	@ApiModelProperty(value="广告标示符",example="广告标示符")
	private String idfa;
	/**
	 * ip
	 */
	@ApiModelProperty(value="ip",example="ip")
	private String ip;
	/**
	 * mac
	 */
	@ApiModelProperty(value="mac",example="mac")
	private String mac;
	/**
	 * 回调地址
	 */
	@ApiModelProperty(value="回调地址",example="回调地址")
	private String callback;
	/**
	 * 设备的Id
	 */
	@ApiModelProperty(value="设备的Id",example="设备的Id")
	private String deviceId;
	/**
	 * 设备版本
	 */
	@ApiModelProperty(value="设备版本",example="设备版本")
	private String deviceVersion;
	/**
	 * 设备型号
	 */
	@ApiModelProperty(value="设备型号",example="设备型号")
	private String deviceType ;
	/**
	 * 状态，1已点击，2已发送，3已返回
	 */
	@ApiModelProperty(value="状态，1已点击，2已发送，3已返回",example="状态，1已点击，2已发送，3已返回")
	private String status ;
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
	public Integer getReportDataId() {
		return reportDataId;
	}
	public void setReportDataId(Integer reportDataId) {
		this.reportDataId = reportDataId;
	}
	public String getIdfa() {
		return idfa;
	}
	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
