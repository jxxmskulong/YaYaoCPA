#设置初始角色
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("超级管理员","超级管理员",now());
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("普通管理员","普通管理员",now());
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("广告主","广告主",now());
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("渠道主","渠道主",now());
 
#设置初始管理员密码MD5加密123456
INSERT IGNORE INTO account_tb (nickname,phone,email,password,create_date,login_date,role_id,status,sex,auth) 
VALUES ("聂跃","15111336587","278076304@qq.com","11874bb6149dd45428da628c9766b252",now(),now(),6,0,1,0); 
#财务
INSERT IGNORE INTO finance_tb (money,recharge,consume,withdrawals,refund,frozen,recommend_commission,base_profit,create_date,update_date,account_id) 
VALUES (10000,0,0,0,0,0,0,0,now(),now(),1000);     
  
