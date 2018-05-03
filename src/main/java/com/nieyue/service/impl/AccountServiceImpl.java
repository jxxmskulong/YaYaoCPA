package com.nieyue.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nieyue.bean.Account;
import com.nieyue.dao.AccountDao;
import com.nieyue.service.AccountService;



/** 系统用户管理接口实现 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account,Integer> implements AccountService{
	@Autowired
	AccountDao accountDao;
	/** 系统管理员登录 */
	public Account accountLogin(Integer accountId, String password){
		Account account =accountDao.accountLogin(accountId, password);
		if(account!=null){
			account.setLoginDate(new Date());
			accountDao.update(account);
		}
		return account;
	}

}