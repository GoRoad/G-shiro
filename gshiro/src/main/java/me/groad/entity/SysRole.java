package me.groad.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {

  private Integer id;
  //是否可用,如果不可用将不会添加给用户
  private Boolean available = Boolean.FALSE;
  //角色描述
  private String description;
  //角色标识程序中判断使用,如"admin",这个是唯一的:
  private String role;

}
