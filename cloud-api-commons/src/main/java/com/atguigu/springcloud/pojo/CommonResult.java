package com.atguigu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陆小根
 * date: 2022/07/20
 * Description:
 *
 * 返回结果集
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{

  // 三个构造方法

  // 404 not_found

  private Integer code;
  private String message;
  private T data;

  public CommonResult(Integer code, String message) {
    this(code,message,null);
  }
}
