package me.groad.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description 权限实体类
 * @author Groad
 * @date 2019/2/26 16:26
 * @params
 * @return
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {

  private Integer id;
  //名称
  private String name;
  //权限字符串
  private String permission;
  //资源路径
  private String url;

}
