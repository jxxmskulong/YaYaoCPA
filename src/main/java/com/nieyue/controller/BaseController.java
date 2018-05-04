package com.nieyue.controller;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.exception.CommonRollbackException;
import com.nieyue.exception.NotAnymoreException;
import com.nieyue.exception.NotIsNotExistException;
import com.nieyue.service.BaseService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResultList;


/**
 * 基础controller
 * @author yy
 *
 */
public  class BaseController<T,ID>  {
	

	@Autowired
	protected BaseService<T,ID> baseService;
	protected StateResultList<T> result;//返回数据
	protected StateResultList<Integer> result2;//返回数据
	protected StateResultList<List<T>> result3;//返回数据
/*	protected StateResultList<Map<String,T>> result;//返回数据
	protected StateResultList<Map<String,Integer>> result2;//返回数据
	protected StateResultList<Map<String,List<T>>> result3;//返回数据
*/	
	/**
	 * 获取泛型对象的类对象
	 * @param t
	 * @return
	 */
	public Class<T> getT() {
		Type genType = getClass().getGenericSuperclass();  
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
		@SuppressWarnings("unchecked")
		Class<T> entityClass = (Class<T>) params[0];
		return entityClass;
	}
	/**
	 * 泛型参数化对象动态传值给 泛型持久化对象
	 * @param paramT 泛型参数对象
	 * @param daoT 泛型持久化对象
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public T getObject(T paramT,T daoT){
		//泛型参数对象属性集合
		Field[] paramFileds = paramT.getClass().getDeclaredFields();
		//泛型持久化对象属性集合
		Field[] daoFileds = daoT.getClass().getDeclaredFields();
		try {
		for (int i = 0; i < paramFileds.length; i++) {
			paramFileds[i].setAccessible(true); 
			Object paramFiledsName = paramFileds[i].getName();
			for (int j = 0; j < daoFileds.length; j++) {
				daoFileds[j].setAccessible(true); 
				Object daoFiledsName = daoFileds[j].getName();
				//参数对象的属性类型
				//System.err.println(paramFileds[i].getGenericType().toString());
				//过滤serialVersionUID属性
				if((paramFileds[i].getGenericType().toString().equals("long")&&((String) paramFiledsName).indexOf("serialVersionUID")>-1)
						||(daoFileds[j].getGenericType().toString().equals("long")&&((String) daoFiledsName).indexOf("serialVersionUID")>-1)){
					continue;
				}else 
				//当参数对象的属性值不为null且不为空，且参数对象的属性名与持久化对象的属性名相等时。
				if(paramFileds[i].get(paramT)!=null
						&&!paramFileds[i].get(paramT).equals("")
						&&paramFiledsName.equals(daoFiledsName)){ 
					// 将属性的首字符大写，方便构造get，set方法  
					String paramname = ((String) paramFiledsName).substring(0, 1).toUpperCase() + ((String) daoFiledsName).substring(1);
					// 将属性的首字符大写，方便构造get，set方法  
					String daoname = ((String) daoFiledsName).substring(0, 1).toUpperCase() + ((String) daoFiledsName).substring(1);
					//参数对象的方法
					Method m = paramT.getClass().getMethod("get" + paramname);
					//参数对象的属性值
                    Object value =m.invoke(paramT);
                    //System.err.println(Class.forName("java.lang.Integer"));
                   // System.err.println(paramFileds[i].getGenericType().getTypeName());
                   // System.err.println(paramFileds[i].getGenericType().getClass());
                   // System.err.println(paramFileds[i].getGenericType().getClass().getName());
                   // System.err.println(m.getReturnType().toString());
                    //获取持久化对象的设置方法
                    m = daoT.getClass().getMethod("set"+daoname,Class.forName(m.getReturnType().getTypeName()));                    	
                   /* if(m.getGenericReturnType().toString().equals("class java.lang.Integer")){
                    	//m = daoT.getClass().getMethod("set"+daoname,Class.forName(m.getGenericReturnType().toString()).getClass());                    	
                    	m = daoT.getClass().getMethod("set"+daoname,Integer.class);                    	
                    }else if(m.getGenericReturnType().toString().equals("class java.lang.String")){
                    	m = daoT.getClass().getMethod("set"+daoname,String.class);                    	
                    	
                    }else if(m.getGenericReturnType().toString().equals("class java.util.Date")){
                    	m = daoT.getClass().getMethod("set"+daoname,Date.class);                    	
                    }else if(m.getGenericReturnType().toString().equals("class java.lang.Double")){
                    	m = daoT.getClass().getMethod("set"+daoname,Double.class);                    	
                    }else if(m.getGenericReturnType().toString().equals("class java.lang.Float")){
                    	m = daoT.getClass().getMethod("set"+daoname,Float.class);                    	
                    }*/
                    //System.out.println(Class.forName("class java.lang.Integer").toString());
                    //把参数化对象的值赋值给持久化对象的方法
                    m.invoke(daoT, value);
					//daoFileds[j].set(daoFiledsName, paramFileds[i].get(paramT));
				}
			}
		}
		} catch (Exception e) {
			throw new CommonRollbackException("类型转化异常");
		}
		
		return daoT;
	}
	/**
	 * 获取类型名。再首字母转小写
	 */
	String getName(T t){
		String s=t.getClass().getSimpleName();
		String s1 = s.substring(0, 1); 
		 String s2 = s.substring(1); 
		 String s3 = s1.toLowerCase();  
		 String s4 = s3.concat(s2);  
		return s4;
	}
	/**
	 * 增加
	 */
	public StateResultList<T> add(T t)  {
		//Map<String,T> map=new HashMap<>();
		boolean b=baseService.add(t);
		if(b){
			//map.put(getName(t), t);
			//result=ResultUtil.getSlefSRSuccessList(map);
			result=ResultUtil.getSlefSRSuccessList(t);
			return result;
		}
		result=ResultUtil.getSlefSRFailList(t);
		return result;
	}
	/**
	* 更新
	*/
	public StateResultList<T> update(T t)  {
		//Map<String,T> map=new HashMap<>();
		boolean b=baseService.update(t);
		if(b){
			//map.put(getName(t), t);
			//result=ResultUtil.getSlefSRSuccessList(map);
			result=ResultUtil.getSlefSRSuccessList(t);
			return result;
		}
		result=ResultUtil.getSlefSRFailList(t);
		return result;
	}
	/**
	 * 删除
	 */
	public StateResultList<T> delete(Integer ID)  {
		//Map<String,T> map=new HashMap<>();
		boolean b=baseService.delete(ID);
		if(b){
			//result=ResultUtil.getSlefSRSuccessList(map);
			result=ResultUtil.getSlefSRSuccessList(null);
			return result;
		}
		result=ResultUtil.getSlefSRFailList(null);
		return result;
	}
	/**
	*加载
	*/
	public StateResultList<T> load(Integer id)  {
		//Map<String,T> map=new HashMap<String,T>();
		//try {
			T t=baseService.load(id);
			if(t!=null &&!t.equals("")){
				//map.put(getName(t), t);
				//result=ResultUtil.getSlefSRSuccessList(map);
				result=ResultUtil.getSlefSRSuccessList(t);
				return result;
			}else{
				throw new NotIsNotExistException(" ");//不存在
			}
		/*} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(map);
			return result;
		}*/
	}

	/**
	 * 数量
	 */
	public StateResultList<Integer> count(
			Map<String,Object> eq,
			Map<String,Object> gt,
			Map<String,Object> ge,
			Map<String,Object> lt,
			Map<String,Object> le,
			Map<String,List<Object>> between,
			Map<String,Object> like,
			Map<String,List<Object>> in)  {
		//Map<String,Integer> map=new HashMap<>();
		//try {
			
			int total=baseService.count(eq, gt, ge, lt, le, between, like, in);
			//map.put("total", total);
			//result2=ResultUtil.getSlefSRSuccessList(map);
			result2=ResultUtil.getSlefSRSuccessList(total);
			return result2;
		/*} catch (Exception e) {
			result2=ResultUtil.getSlefSRFailList(map);
			return result2;
		}*/
	}
	/**
	 * 查询
	 */
	public StateResultList<List<T>> list(
			int pageNum,
			int pageSize,
			String orderName,
			String orderWay,
			Map<String, Object> eq,
			Map<String, Object> gt,
			Map<String, Object> ge,
			Map<String, Object> lt,
			Map<String, Object> le,
			Map<String, List<Object>> between,
			Map<String, Object> like,
			Map<String, List<Object>> in)  {
		//Map<String,List<T>> map=new HashMap<>();
		//try {
			List<T> rl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			if(rl.size()>0){
				//map.put("list", rl);
				//result3=ResultUtil.getSlefSRSuccessList(map);
				result3=ResultUtil.getSlefSRSuccessList(rl);
				return result3;
			}else{
				throw new NotAnymoreException();//没有更多
			}
		/*} catch (Exception e) {
			result3=ResultUtil.getSlefSRFailList(map);
			return result3;
		}*/
	}

	
}