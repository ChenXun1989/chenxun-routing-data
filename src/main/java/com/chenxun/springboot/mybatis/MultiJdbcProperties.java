package com.chenxun.springboot.mybatis;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenxun created at 2018/7/22
 */

@Data
@ConfigurationProperties(prefix = MultiJdbcProperties.JDBC_PREFIX)
public class MultiJdbcProperties {

  public static final String JDBC_PREFIX = "jdbc";

  private JdbcProperties master;

  private List<JdbcProperties> slaver =new ArrayList<>();
}
