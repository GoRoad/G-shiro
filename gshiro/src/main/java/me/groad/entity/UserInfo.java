package me.groad.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**  
  * @description 用户实体类
  * @author Groad
  * @date 2019/2/26 16:21
  * @params 
  * @return 
  */  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

  private Integer userId;
  private String name;
  private String password;
  private String salt;
  private byte state;
  private String username;

  /**
   * 密码盐
   * @return
   */
  public String getCredentialsSalt()
  {
    return this.username + this.salt;
  }

}
