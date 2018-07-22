/**
 * Project Name:chenxun-routing-data
 * File Name:RoutingDataSourcePlguns.java
 * Package Name:com.chenxun.springboot.mybatis
 * Date:2016年8月19日下午12:45:02
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 */

package com.chenxun.springboot.mybatis;

import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * ClassName:RoutingDataSourcePlguns <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月19日 下午12:45:02 <br/>
 *
 * @author 陈勋
 * @see
 * @since JDK 1.7
 */
//CHECKSTYLE_OFF:
@Component
@Intercepts({@Signature(method = "query",
    type = Executor.class,
    args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(method = "query",
        type = Executor.class,
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class,
            CacheKey.class, BoundSql.class}), @Signature(method = "queryCursor",
    type = Executor.class,
    args = {MappedStatement.class, Object.class, RowBounds.class})})
public class RoutingDataSourcePlguns implements Interceptor {

  private Properties properties;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    // 非事务 路由
    if (TransactionSynchronizationManager.getCurrentTransactionName() == null) {
      try{
        DataSourceContextHolder.setSlave();
        return invocation.proceed();
      }catch (Throwable throwable){
        throw throwable;
      }finally {
        DataSourceContextHolder.setMaster();
      }
    }
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {

    this.properties = properties;

  }

}

