package com.nieyue.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 渠道广告
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="账户",description="账户")
@Entity
@Table(name="channel_advertise_tb",
		indexes={
		@Index(name="INDEX_ACCOUNTID",columnList = "accountId"),
		@Index(name="INDEX_STATUS",columnList = "status"),
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
	@GeneratedValue(strategy=GenerationType.AUTO,generator="increment")
	@SequenceGenerator(name = "increment",initialValue = 1000)
	private Integer channelAdvertiseId;
	
	
	
}
