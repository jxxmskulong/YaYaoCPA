package com.nieyue.service;

import com.nieyue.bean.Account;

/** 账户接口 */
public interface AccountService extends BaseService<Account, Integer> {
	
	/** 账户登录 */
	public Account accountLogin(Integer accountId,String passwords);
}