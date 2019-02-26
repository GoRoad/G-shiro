package me.groad.config;

import me.groad.entity.UserInfo;
import me.groad.mapper.SysPermissionMapper;
import me.groad.mapper.SysRoleMapper;
import me.groad.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.config
 * @Author: Groad
 * @CreateTime: 2019-02-26 17:12
 * @Description: 验证用户身份和权限
 * @Version: 1.0
 */
public class MyShiroRealm extends AuthorizingRealm
{
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    SysPermissionMapper sysPermissionMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    /**  
      * @description 授权
      * @author Groad
      * @date 2019/2/26 17:19
      * @params [principalCollection]
      * @return org.apache.shiro.authz.AuthorizationInfo
      */  
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        //通过用户名从数据库获得用户的所有资源，并把资源存入authorizationInfo中
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ////得到主要的身份
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        sysRoleMapper.findRoleByUsername(userInfo.getUsername()).stream().forEach(
                sysRole -> {
                    //addRole()添加角色的方法
                    authorizationInfo.addRole(sysRole.getRole());
                    sysPermissionMapper.findPermissionByRoleId(sysRole.getId()).stream().forEach(
                            sysPermission ->{
                                //addStringPermission() 添加权限方法
                                authorizationInfo.addStringPermission(sysPermission.getPermission());
                            }
                    );
                }
        );
        return authorizationInfo;
    }

    /**  
      * @description 身份认证
      * @author Groad
      * @date 2019/2/26 17:20
      * @params [authenticationToken]
      * @return org.apache.shiro.authc.AuthenticationInfo
      */  
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("---------->>userInfo" + userInfo);
        if (userInfo == null)
        {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                userInfo,
                //密码
                userInfo.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                getName()
        );
        return authenticationInfo;
    }
}
