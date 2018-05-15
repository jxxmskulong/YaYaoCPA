package com.nieyue.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nieyue.bean.Account;
import com.nieyue.dao.AccountDao;



/** 
 * 账户接口实现
 */
@Repository
public  class AccountDaoImpl extends BaseDaoImpl<Account,Integer> implements AccountDao{

	/** 
	 * 账户登录
	 */
	public Account accountLogin(Integer accountId, String password)  {
			
		    Criteria c = getSession().createCriteria(Account.class);
			c.add(Restrictions.eq("accountId", accountId));
			c.add(Restrictions.eq("password",password));
			Account Account = (Account) c.uniqueResult();
			return Account;
	}

}