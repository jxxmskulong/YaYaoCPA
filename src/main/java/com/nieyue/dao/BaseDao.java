package com.nieyue.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础数据访问接口
 * @author 聂跃
 * @date 2018年4月17日
 */
public interface BaseDao<T, ID> {
	/** 新增*/	
	public boolean add(T t) ;	
	/** 删除*/	
	public boolean delete(Integer ID) ;	
	/** 更新*/	
	public boolean update(T t) ;	
	/** 装载*/	
	public T load(Integer ID) ;	
	/** 
	 * 数量
	 * eq =  等于
	 * gt >  大于
	 * ge >= 大于等于
	 * lt <  小于
	 * between 两个之间
	 * like 模糊查询
	 * in  范围里面
	 * and 并且 (自定义时需要)
	 * or 或者(自定义时需要)
	 */	
	public int count(
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in
			);	
	/** 浏览*/
	public List<T> list(
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay,
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in
			);	
}
