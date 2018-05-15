package com.nieyue.service;

import java.util.List;
import java.util.Map;

/** 
 * 基础服务管理接口
 */
public interface BaseService<T,ID> {

	/** 新增*/	
	public boolean add(T t) ;	
	/** 删除*/	
	public boolean delete(Integer ID) ;	
	/** 更新*/	
	public boolean update(T t) ;	
	/** 装载*/	
	public T load(Integer ID) ;	 
	/** 数量*/	
	public int count(
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in,
			Map<String,Object> or
			) ;
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
			Map<String,List<Object>> in,
			Map<String,Object> or
			);
}