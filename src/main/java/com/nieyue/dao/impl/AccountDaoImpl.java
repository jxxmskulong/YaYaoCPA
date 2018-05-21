package com.nieyue.dao.impl;

import org.springframework.stereotype.Repository;

import com.nieyue.bean.Account;
import com.nieyue.dao.AccountDao;



/** 
 * 账户接口实现
 */
@Repository
public  class AccountDaoImpl extends BaseDaoImpl<Account,Integer> implements AccountDao{


}