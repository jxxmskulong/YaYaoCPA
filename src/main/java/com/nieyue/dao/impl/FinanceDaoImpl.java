package com.nieyue.dao.impl;

import org.springframework.stereotype.Repository;

import com.nieyue.bean.Finance;
import com.nieyue.dao.FinanceDao;

/** 
 * 财务接口实现
 */
@Repository
public class FinanceDaoImpl extends BaseDaoImpl<Finance,Integer> implements FinanceDao{
}