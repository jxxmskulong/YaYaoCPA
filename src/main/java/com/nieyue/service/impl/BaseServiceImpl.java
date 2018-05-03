package com.nieyue.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.dao.BaseDao;
import com.nieyue.service.BaseService;


/**
 * 基础接口实现类
 * 定义为抽象类，不交由spring ioc管理,子类交由spring管理即可.
 * @author 聂跃
 * @date 2018年4月17日
 */
public abstract class BaseServiceImpl<T,ID>  implements BaseService<T,ID>{
	@Autowired
	private BaseDao<T,ID> baseDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean add(T t) {
		return baseDao.add(t);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean delete(Integer ID) {
		return baseDao.delete(ID);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(T t) {
		return baseDao.update(t);
	}

	@Override
	@Transactional(readOnly=true)
	public T load(Integer ID) {
		return baseDao.load(ID);
	}

	@Override
	@Transactional(readOnly=true)
	public int count(Map<String, Object> eq, Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt,
			Map<String, Object> le, Map<String, List<Object>> between, Map<String, Object> like,
			Map<String, List<Object>> in) {
		return baseDao.count(eq, gt, ge, lt, le, between, like, in);
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		return baseDao.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
	}

}