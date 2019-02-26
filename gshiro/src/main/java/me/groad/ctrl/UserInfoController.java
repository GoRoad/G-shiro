package me.groad.ctrl;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.ctrl
 * @Author: Groad
 * @CreateTime: 2019-02-26 19:02
 * @Description: 角色权限操作
 * @Version: 1.0
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController
{
    /**  
      * @description 用户查询
      * @author Groad
      * @date 2019/2/26 19:10
      * @params []
      * @return java.lang.String
      */  
    @RequestMapping("/userList")
    //@RequiresPermissions:当前Subject需要拥有某些特定的权限时，才能执行被该注解标注的方法。如果当前Subject不具有这样的权限，则方法不会被执行。
    @RequiresPermissions("userInfo:view")
    public String userInfo()
    {
        return "userInfo";
    }

    /**  
      * @description 用户添加
      * @author Groad
      * @date 2019/2/26 19:11
      * @params []
      * @return java.lang.String
      */  
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd()
    {
        return "userInfoAdd";
    }

    /**  
      * @description 用户删除
      * @author Groad
      * @date 2019/2/26 19:13
      * @params []
      * @return java.lang.String
      */  
    @RequestMapping("/userDel")
    //权限管理
    @RequiresPermissions("userInfo:del")
    public String userDel()
    {
        return "userInfoDel";
    }
}
