/**
 * Project Name:spring-boot-starter-mybatis
 * File Name:MyMapper.java
 * Package Name:com.midai.springboot.mybatis
 * Date:2016年7月27日下午5:54:10
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.springboot.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ClassName:MyMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年7月27日 下午5:54:10 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface MyMapper<T> extends Mapper<T> ,MySqlMapper<T>{

}

