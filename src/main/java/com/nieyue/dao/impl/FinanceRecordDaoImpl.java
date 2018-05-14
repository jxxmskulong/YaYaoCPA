package com.nieyue.dao.impl;

import org.springframework.stereotype.Repository;

import com.nieyue.bean.FinanceRecord;
import com.nieyue.dao.FinanceRecordDao;

/** 
 * 财务记录接口实现
 */
@Repository
public class FinanceRecordDaoImpl extends BaseDaoImpl<FinanceRecord,Integer> implements FinanceRecordDao{
}