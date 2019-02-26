package me.groad.service.impl;

import me.groad.entity.UserInfo;
import me.groad.mapper.UserInfoMapper;
import me.groad.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.service.impl
 * @Author: Groad
 * @CreateTime: 2019-02-26 17:05
 * @Description:
 * @Version: 1.0
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService
{
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByUsername(String username)
    {
        return userInfoMapper.findByUsername(username);
    }
}
