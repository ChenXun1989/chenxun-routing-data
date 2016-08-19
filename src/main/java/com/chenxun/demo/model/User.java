/**
 * Project Name:demo-dubbo-provider
 * File Name:User.java
 * Package Name:com.midai.demo.model
 * Date:2016年7月27日下午6:31:51
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.chenxun.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年7月27日 下午6:31:51 <br/>
 * 
 * @author 陈勋
 * @version
 * @since JDK 1.7
 * @see
 */
@Data
@Table(name="TBL_USER")
public class User implements Serializable {
	@Id
	private int id;
	private String name;
	@Column(name = "SCORE_SUM")
	private String sumScore;
	@Column(name = "SCORE_AVG")
	private String avgScore;
	private int age;
}
