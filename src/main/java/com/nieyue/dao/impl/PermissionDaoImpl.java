package com.nieyue.dao.impl;

import org.springframework.stereotype.Repository;

import com.nieyue.bean.Permission;
import com.nieyue.dao.PermissionDao;

/** 
 * 权限接口实现
 */
@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission,Integer> implements PermissionDao{
}