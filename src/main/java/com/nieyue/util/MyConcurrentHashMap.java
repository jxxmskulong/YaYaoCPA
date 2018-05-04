package com.nieyue.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="Map",description="Map")
public class MyConcurrentHashMap<K,T>  extends ConcurrentHashMap<K,T>{
	@Override
	@ApiModelProperty(value="dfs",example="sdf")
	public T get(Object key) {
		// TODO Auto-generated method stub
		return super.get(key);
	}
	@Override
	@ApiModelProperty(value="dfs33",example="sd33f")
	public T put(K key, T value) {
		// TODO Auto-generated method stub
		return super.put(key, value);
	}
	@Override
	@ApiModelProperty(value="dfs3344",example="sd333f")
	public void putAll(Map<? extends K, ? extends T> m) {
		// TODO Auto-generated method stub
		super.putAll(m);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		MyConcurrentHashMap<String, String > mcm=new MyConcurrentHashMap<String, String>();
	}
}
