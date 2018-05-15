package com.nieyue.dao;

import org.hibernate.Criteria;

import com.nieyue.bean.Account;

/** 账户管理接口 */
public interface AccountDao extends BaseDao<Account,Integer> {

	/** 账户登录 */
	public Account accountLogin(Integer accountId,String passwords);
	
}