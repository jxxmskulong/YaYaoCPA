package com.nieyue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Role;
import com.nieyue.exception.CommonRollbackException;
import com.nieyue.service.RoleService;
import com.nieyue.util.StateResultList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 角色控制类
 * @author yy
 *
 */
@Api(tags={"role"},value="角色",description="角色管理")
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role,Integer>{
	@Autowired
	private RoleService roleService;
	
	/**
	 * 角色分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@ApiOperation(value = "角色列表", notes = "角色分页浏览")
	@ApiImplicitParams({
	  @ApiImplicitParam(name="pageNum",value="页头数位",dataType="int", paramType = "query",defaultValue="1"),
	  @ApiImplicitParam(name="pageSize",value="每页数目",dataType="int", paramType = "query",defaultValue="10"),
	  @ApiImplicitParam(name="orderName",value="排序字段",dataType="string", paramType = "query",defaultValue="updateDate"),
	  @ApiImplicitParam(name="orderWay",value="排序方式",dataType="string", paramType = "query",defaultValue="desc")
	  })
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<Role>> browsePagingRole(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="updateDate") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
		StateResultList<List<Role>> lr = super.list(pageNum, pageSize, orderName, orderWay,null, null, null, null, null, null, null, null,null);
		return lr;
			
	}
	/**
	 * 角色修改
	 * @return
	 */
	@ApiOperation(value = "角色修改", notes = "角色修改")
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Role> updateRole(
			@ModelAttribute Role role,HttpSession session)  {
		Role nrole =new Role();
			Map<String, Object> eq=new HashMap<String,Object>();
			eq.put("name", role.getName());
			List<Role> rl = roleService.list(1,1,null,null,eq, null, null, null, null, null, null, null,null);
			//存在不是自己就是别人的
			if(rl.size()>0){
				Role rr = rl.get(0);
				//更新自己
				if(rr.getRoleId().equals(role.getRoleId())){
					nrole=rr;
				}else{
					//更新后两个一样的
					throw new CommonRollbackException("已经存在");					
				}
			}else{//不存在直接更新
				nrole = roleService.load(role.getRoleId());				
			}
		nrole.setUpdateDate(new Date());
		getObject(role, nrole);
		StateResultList<Role> r = super.update(nrole);
		return r;
	}
	/**
	 * 角色增加
	 * @return 
	 */
	@ApiOperation(value = "角色增加", notes = "角色增加")
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Role> addRole(
			@ModelAttribute Role role, HttpSession session) {
		role.setUpdateDate(new Date());
		Map<String, Object> eq=new HashMap<String,Object>();
		eq.put("name", role.getName());
		 int count = roleService.count(eq, null, null, null, null, null, null, null,null);
		if(count>0){
			throw new CommonRollbackException("已经存在");
		}
		StateResultList<Role> r = super.add(role);
		return r;
	}
	/**
	 * 角色删除
	 * @return
	 */
	@ApiOperation(value = "角色删除", notes = "角色删除")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="roleId",value="角色ID",dataType="int", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Role> deleteRole(
			@RequestParam("roleId") Integer roleId,HttpSession session)  {
		StateResultList<Role> r = super.delete(roleId);
		return r;
	}
	/**
	 * 角色浏览数量
	 * @return
	 */
	@ApiOperation(value = "角色数量", notes = "角色数量查询")
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Integer> count(
			HttpSession session)  {
		StateResultList<Integer> r = super.count(null, null, null, null, null, null, null, null,null);
		return r;
	}
	/**
	 * 角色单个加载
	 * @return
	 */
	@ApiOperation(value = "角色单个加载", notes = "角色单个加载")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="roleId",value="角色ID",dataType="int", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/load", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList<Role> loadRole(
			@RequestParam("roleId") Integer roleId,HttpSession session)  {
		StateResultList<Role> r = super.load(roleId);
		return r;
	}
	
}
