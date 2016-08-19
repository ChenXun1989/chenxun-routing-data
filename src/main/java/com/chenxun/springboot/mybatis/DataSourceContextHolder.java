/**
 * Project Name:chenxun-routing-data
 * File Name:DataSourceContextHolder.java
 * Package Name:com.chenxun.demo.config
 * Date:2016年8月18日下午3:06:16
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.springboot.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.javassist.compiler.ast.IntConst;

/**
 * ClassName:DataSourceContextHolder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月18日 下午3:06:16 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DataSourceContextHolder {
	
	 
     private static final List<String>  list=new ArrayList<String>();
	
	 private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	 
	 
	 public static void setDataSourceType(String dataSourceType) {  
	        contextHolder.set(dataSourceType);  
	  } 
	 
	  public static String getDataSourceType() {  
	        return contextHolder.get();  
	  }  
	  
	  public static void setSlave(){
		   	 
		  //负载均衡算法 随机 轮询  权重
		  Random r=new Random();
		  int index=r.nextInt(list.size());
		  setDataSourceType(list.get(index));	  	  
	  }
	  
	  public static void addKeyList(String key){
		  list.add(key);
	  }
	  
	  public static void setMaster(){
		  clearDataSourceType(); 
	  }
	  
	  public static void clearDataSourceType() {  
	        contextHolder.remove();  
	  }

	

}

