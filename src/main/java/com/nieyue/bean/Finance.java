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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 财务
 * @author 聂跃
 * @date 2017年4月12日
 */
@ApiModel(value="财务",description="财务")
@Entity
@Table(name="finance_tb",
		indexes={
		@Index(name="INDEX_MONEY",columnList = "money"),
		@Index(name="INDEX_ACCOUNTID",columnList = "accountId")
		})
public class Finance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 财务id
	 */
	@ApiModelProperty(value="财务id",example="财务id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="identity")
	@SequenceGenerator(name = "identity",initialValue = 1000,allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="uuid")
	//@SequenceGenerator(name = "uuid")
	private Integer financeId;
	/**
	 * 提现密码
	 */
	@ApiModelProperty(value="提现密码",example="提现密码")
	private String password;
	/**
	 * 余额
	 */
	@ApiModelProperty(value="余额",example="余额")
	private Double money;
	/**
	 * 充值金额
	 */
	@ApiModelProperty(value="充值金额",example="充值金额")
	private Double recharge;
	/**
	 * 消费金额
	 */
	@ApiModelProperty(value="消费金额",example="消费金额")
	private Double consume;
	/**
	 * 提现金额
	 */
	@ApiModelProperty(value="提现金额",example="提现金额")
	private Double withdrawals;
	/**
	 * 收益
	 */
	@ApiModelProperty(value="收益",example="收益")
	private Double profit;
	/**
	 * 赠送金钱
	 */
	@ApiModelProperty(value="赠送金钱",example="赠送金钱")
	private Double baseProfit;
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
	 * 账户id外键
	 */
	@ApiModelProperty(value="账户id外键",example="账户id外键")
	private Integer accountId;
	public Integer getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getRecharge() {
		return recharge;
	}
	public void setRecharge(Double recharge) {
		this.recharge = recharge;
	}
	public Double getConsume() {
		return consume;
	}
	public void setConsume(Double consume) {
		this.consume = consume;
	}
	public Double getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(Double withdrawals) {
		this.withdrawals = withdrawals;
	}
	public Double getBaseProfit() {
		return baseProfit;
	}
	public void setBaseProfit(Double baseProfit) {
		this.baseProfit = baseProfit;
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
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
}
