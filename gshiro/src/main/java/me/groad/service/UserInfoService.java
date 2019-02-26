package me.groad.service;

import me.groad.entity.UserInfo;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.service
 * @Author: Groad
 * @CreateTime: 2019-02-26 17:02
 * @Description: 用户Service层
 * @Version: 1.0
 */
public interface UserInfoService
{
    //通过username查找用户信息
    UserInfo findByUsername(String username);
}
