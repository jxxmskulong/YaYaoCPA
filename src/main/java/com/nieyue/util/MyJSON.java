package com.nieyue.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.nieyue.bean.Role;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 封装自己JSON
 * @author 聂跃
 * @date 2018年4月19日
 */
public class MyJSON {
   public static JSONObject getJSONObject(Object obj){
	   JsonConfig jsonConfig = new JsonConfig();  

	 //这里Date.class 需要根据你用的日期格式进行修改 比如Timestamp.class、Date.class、Time.class
	 jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
	 jsonConfig.registerJsonValueProcessor(Time.class, new JsonTimeValueProcessor());

	 //使用JSONSerializer.toJSON()与JSONObject.fromObject()同理
	 return JSONObject.fromObject(obj, jsonConfig); 
   }
   public static void main(String[] args) {
	Role role=new Role();
	role.setUpdateDate(new Date());
	JSONObject json=MyJSON.getJSONObject(role);
	System.out.println(json);
}
}
/**
 * 转化自己的格式日期
 * @author 聂跃
 * @date 2018年4月19日
 */
class JsonDateValueProcessor implements JsonValueProcessor {  
    private String format = "yyyy-MM-dd HH:mm:ss";  
  
    public JsonDateValueProcessor() {  
        super();  
    }  
  
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    }  
  
    @Override  
    public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
  
    @Override  
    public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
  
    private Object process(Object value) {  
        if (value instanceof Date) {  
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);  
            return sdf.format(value);  
        }  
        return value == null ? "" : value.toString();  
    }  
}
    /**
     * 转化自己的格式时间
     * @author 聂跃
     * @date 2018年4月19日
     */
    class JsonTimeValueProcessor implements JsonValueProcessor {  
        private String format = "HH:mm:ss";  
      
        public JsonTimeValueProcessor() {  
            super();  
        }  
      
        public JsonTimeValueProcessor(String format) {  
            super();  
            this.format = format;  
        }  
      
        @Override  
        public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {  
            return process(paramObject);  
        }  
      
        @Override  
        public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {  
            return process(paramObject);  
        }  
      
        private Object process(Object value) {  
            if (value instanceof Time) {  
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);  
                return sdf.format(value);  
            }  
            return value == null ? "" : value.toString();  
        }  
      
    }  
  
