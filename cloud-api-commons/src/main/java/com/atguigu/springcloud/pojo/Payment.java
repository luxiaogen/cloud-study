package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

  private Long id; // 因为数据库的类型是 bigint
  private String serial;

}
