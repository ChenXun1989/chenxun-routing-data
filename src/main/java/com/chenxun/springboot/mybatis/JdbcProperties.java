/**
 * Project Name:demo-dubbo-provider
 * File Name:JdbcProperties.java
 * Package Name:com.midai.springboot.mybatis
 * Date:2016年7月27日下午9:27:09
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.chenxun.springboot.mybatis;

import java.sql.SQLException;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName:JdbcProperties <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月27日 下午9:27:09 <br/>
 * 
 * @author 陈勋
 * @version
 * @since JDK 1.7
 * @see
 */
@Data
public class JdbcProperties {

	
	private String id;
	private String url;
	private String username;
	private String password;
	
	private int initialSize = 0;
	private int maxActive = 20;
	private int minIdle = 0;
	private int maxWait = 60000;
	
	private boolean poolPreparedStatements = true;
	private int maxPoolPreparedStatementPerConnectionSize = 33;
	
	private boolean testOnBorrow = false;
	private boolean testOnReturn = false;
	private boolean testWhileIdle = true;

	private int timeBetweenEvictionRunsMillis = 60000;
	private int minEvictableIdleTimeMillis = 25200000;

	private boolean removeAbandoned = true;
	private int removeAbandonedTimeout = 1800;
	private boolean logAbandoned = true;
	
	private String validationQuery;
	
	

}
