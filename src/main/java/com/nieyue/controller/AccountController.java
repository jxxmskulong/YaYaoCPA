package com.nieyue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Account;
import com.nieyue.exception.AccountIsExistException;
import com.nieyue.service.AccountService;
import com.nieyue.util.MyDESutil;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResultList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 账户控制类
 * @author yy
 *
 */
@Api(tags={"account"},value="账户",description="账户管理")
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController<Account,Integer>{
	@Autowired
	private AccountService accountService;
	
	/**
	 * 账户分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@ApiOperation(value = "账户列表", notes = "账户分页浏览")
	@ApiImplicitParams({
	  @ApiImplicitParam(name="accountId",value="账户ID",dataType="int", paramType = "query"),
	  @ApiImplicitParam(name="auth",value="认证，0没认证，1审核中，2已认证",dataType="int", paramType = "query"),
	  @ApiImplicitParam(name="phone",value="手机号，模糊查询",dataType="string", paramType = "query"),
	  @ApiImplicitParam(name="email",value="email，模糊查询",dataType="string", paramType = "query"),
	  @ApiImplicitParam(name="realname",value="真实姓名，模糊查询",dataType="string", paramType = "query"),
	  @ApiImplicitParam(name="roleId",value="角色ID",dataType="int", paramType = "query"),
	  @ApiImplicitParam(name="status",value="状态，0正常，1锁定，2，异常",dataType="int", paramType = "query"),
	  @ApiImplicitParam(name="createDate",value="创建时间",dataType="date-time", paramType = "query"),
	  @ApiImplicitParam(name="loginDate",value="最后登陆时间",dataType="date-time", paramType = "query"),
	  @ApiImplicitParam(name="pageNum",value="页头数位",dataType="int", paramType = "query",defaultValue="1"),
	  @ApiImplicitParam(name="pageSize",value="每页数目",dataType="int", paramType = "query",defaultValue="10"),
	  @ApiImplicitParam(name="orderName",value="排序字段",dataType="string", paramType = "query",defaultValue="updateDate"),
	  @ApiImplicitParam(name="orderWay",value="排序方式",dataType="string", paramType = "query",defaultValue="desc")
	  })
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<Account>> browsePagingAccount(
			@RequestParam(value="accountId",required=false)Integer  accountId,
			@RequestParam(value="auth",required=false)Integer auth,
			@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="email",required=false)String email,
			@RequestParam(value="realname",required=false)String realname,
			@RequestParam(value="roleId",required=false)Integer roleId,
			@RequestParam(value="status",required=false)Integer status,
			@RequestParam(value="createDate",required=false)Date createDate,
			@RequestParam(value="loginDate",required=false)Date loginDate,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="updateDate") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
			Map<String, Object> eq=new HashMap<String,Object>();
			eq.put("accountId", accountId);
			eq.put("auth", auth);
			eq.put("phone", phone);
			eq.put("email", email);
			eq.put("realname", realname);
			eq.put("roleId", roleId);
			eq.put("status", status);
			eq.put("createDate", createDate);
			eq.put("loginDate", loginDate);
			StateResultList<List<Account>> lr = super.list(pageNum, pageSize, orderName, orderWay,eq, null, null, null, null, null, null, null);
			return lr;
			
	}
	/**
	 * 账户修改
	 * @return
	 */
	@ApiOperation(value = "账户修改", notes = "账户修改")
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Account> updateAccount(
			@ModelAttribute Account account,HttpSession session)  {
			Account nAccount =new Account();
			if(StringUtils.isNotEmpty(account.getPhone())){
				Map<String, Object> eq1=new HashMap<String,Object>();
				eq1.put("phone", account.getPhone());
				eq1.put("accountId", account.getAccountId());				
				List<Account> rl = accountService.list(1,1,null,null,eq1, null, null, null, null, null, null, null);
				if(rl.size()>0){
					throw new AccountIsExistException();//账户已经存在
				}
			}
			if(StringUtils.isNotEmpty(account.getEmail())){
				Map<String, Object> eq2=new HashMap<String,Object>();
				eq2.put("email", account.getEmail());
				eq2.put("accountId", account.getAccountId());				
				List<Account> rl = accountService.list(1,1,null,null,eq2, null, null, null, null, null, null, null);
				if(rl.size()>0){
					throw new AccountIsExistException();//账户已经存在
				}
			}
			if(account.getPassword()!=null){
				account.setPassword(MyDESutil.getMD5(account.getPassword()));
			}
		nAccount = accountService.load(account.getAccountId());				
		getObject(account, nAccount);
		boolean b=baseService.update(nAccount);
		if(b){
			session.setAttribute("account", account);
			result=ResultUtil.getSlefSRSuccessList(nAccount);
		return result;
		}
		result=ResultUtil.getSlefSRFailList(nAccount);
		return result;
	}
	/**
	 * 账户增加
	 * @return 
	 */
	@ApiOperation(value = "账户增加", notes = "账户增加")
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Account> addAccount(
			@ModelAttribute Account account, HttpSession session) {
		if(StringUtils.isNotEmpty(account.getPhone())){
			Map<String, Object> eq1=new HashMap<String,Object>();
			eq1.put("phone", account.getPhone());
			eq1.put("accountId", account.getAccountId());				
			List<Account> rl = accountService.list(1,1,null,null,eq1, null, null, null, null, null, null, null);
			if(rl.size()>0){
				throw new AccountIsExistException();//账户已经存在
			}
		}
		if(StringUtils.isNotEmpty(account.getEmail())){
			Map<String, Object> eq2=new HashMap<String,Object>();
			eq2.put("email", account.getEmail());
			eq2.put("accountId", account.getAccountId());				
			List<Account> rl = accountService.list(1,1,null,null,eq2, null, null, null, null, null, null, null);
			if(rl.size()>0){
				throw new AccountIsExistException();//账户已经存在
			}
		}
		account.setCreateDate(new Date());
		account.setLoginDate(new Date());
		StateResultList<Account> r = super.add(account);
		return r;
	}
	/**
	 * 账户删除
	 * @return
	 */
	@ApiOperation(value = "账户删除", notes = "账户删除")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="accountId",value="账户ID",dataType="int", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Account> deleteAccount(
			@RequestParam("accountId") Integer accountId,HttpSession session)  {
		StateResultList<Account> r = super.delete(accountId);
		return r;
	}
	/**
	 * 账户浏览数量
	 * @return
	 */
	@ApiOperation(value = "账户数量", notes = "账户数量查询")
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<Integer> count(
			HttpSession session)  {
		StateResultList<Integer> r = super.count(null, null, null, null, null, null, null, null);
		return r;
	}
	/**
	 * 账户单个加载
	 * @return
	 */
	@ApiOperation(value = "账户单个加载", notes = "账户单个加载")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="accountId",value="账户ID",dataType="int", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/load", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList<Account> loadAccount(
			@RequestParam("accountId") Integer accountId,HttpSession session)  {
		StateResultList<Account> r = super.load(accountId);
		return r;
	}
	
}
