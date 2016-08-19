/**
 * Project Name:chenxun-routing-data
 * File Name:MultiJdbcProerties.java
 * Package Name:com.chenxun.springboot.mybatis
 * Date:2016年8月19日上午11:07:16
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.springboot.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * ClassName:MultiJdbcProerties <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月19日 上午11:07:16 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */

@Data
@ConfigurationProperties(prefix = MultiJdbcProerties.JDBC_PREFIX)
public class MultiJdbcProerties {

	public static final String JDBC_PREFIX = "jdbc";
	
	private JdbcProperties master;
	
	private List<JdbcProperties> slaver =new ArrayList<>();;
}

