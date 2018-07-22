/**
 * Project Name:chenxun-routing-data
 * File Name:DataSourceContextHolder.java
 * Package Name:com.chenxun.demo.config
 * Date:2016年8月18日下午3:06:16
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 */

package com.chenxun.springboot.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName:DataSourceContextHolder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月18日 下午3:06:16 <br/>
 *
 * @author 陈勋
 * @see
 * @since JDK 1.7
 */
public class DataSourceContextHolder {


  private static final List<String> list = new ArrayList<String>();

  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
  private static final ThreadLocal<Boolean> isMaster = new ThreadLocal<>();


  public static void setDataSourceType(String dataSourceType) {
    contextHolder.set(dataSourceType);
  }

  public static String getDataSourceType() {
    return contextHolder.get();
  }

  public static void setSlave() {

    //负载均衡算法 随机 轮询  权重
    Random r = new Random();
    int index = r.nextInt(list.size());
    setDataSourceType(list.get(index));
    isMaster.set(false);
  }

  public static void addKeyList(String key) {
    list.add(key);
  }

  public static void setMaster() {
    clearDataSourceType();
  }

  public static void clearDataSourceType() {
    contextHolder.remove();
    isMaster.remove();
  }

  public  static boolean isCurrentMaster() {
    return isMaster.get() == null;
  }



}

