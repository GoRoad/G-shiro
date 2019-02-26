package me.groad.mapper;

import me.groad.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.mapper
 * @Author: Groad
 * @CreateTime: 2019-02-26 16:38
 * @Description: 用户mapper接口
 * @Version: 1.0
 */
@Component
public interface UserInfoMapper
{
    //通过username查找用户角色信息
    UserInfo findByUsername(@Param("username") String username);
}
