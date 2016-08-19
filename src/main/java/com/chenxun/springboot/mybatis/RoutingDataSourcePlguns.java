/**
 * Project Name:chenxun-routing-data
 * File Name:RoutingDataSourcePlguns.java
 * Package Name:com.chenxun.springboot.mybatis
 * Date:2016年8月19日下午12:45:02
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.springboot.mybatis;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

/**
 * ClassName:RoutingDataSourcePlguns <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月19日 下午12:45:02 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
@Intercepts({ @Signature(method = "query", type = Executor.class,
args = { MappedStatement.class, Object.class , RowBounds.class , ResultHandler.class}),
			@Signature(method = "query", type = Executor.class,
args = { MappedStatement.class, Object.class , RowBounds.class , ResultHandler.class,
				CacheKey.class, BoundSql.class}),
			@Signature(method = "queryCursor", type = Executor.class,
					args = { MappedStatement.class, Object.class, RowBounds.class})
})
public class RoutingDataSourcePlguns implements Interceptor {
	
	private Properties properties ;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
        DataSourceContextHolder.setSlave();	
		Object obj=invocation.proceed();
		DataSourceContextHolder.setMaster();
		return obj;
	}

	@Override
	public Object plugin(Object target) {	
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

		this.properties=properties;

	}

}

