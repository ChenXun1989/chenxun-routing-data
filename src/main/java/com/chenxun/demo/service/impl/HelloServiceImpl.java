/**
 * Project Name:demo-dubbo-provider
 * File Name:HelloServiceImpl.java
 * Package Name:com.midai.demo.service.impl
 * Date:2016年7月27日下午1:13:37
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 */

package com.chenxun.demo.service.impl;

import java.util.List;

import com.chenxun.demo.mapper.UserMapper;
import com.chenxun.demo.model.User;
import com.chenxun.demo.service.HelloService;
import com.chenxun.springboot.mybatis.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:HelloServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年7月27日 下午1:13:37 <br/>
 *
 * @author 陈勋
 * @see
 * @since JDK 1.7
 */

@Service
public class HelloServiceImpl implements HelloService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public void say1() {

    List<User> list = userMapper.selectAll();
    System.out.println(list);
    User user = new User();
    user.setAge(13);
    userMapper.insert(user);
  }


  @Override
  @Transactional
  public void say2() {
    List<User> list = userMapper.selectAll();
    System.out.println(list);


  }

}

