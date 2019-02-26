package me.groad.mapper;

import me.groad.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.mapper
 * @Author: Groad
 * @CreateTime: 2019-02-26 16:34
 * @Description: 角色mapper接口, 一个用户对应多个角色
 * @Version: 1.0
 */
@Component
public interface SysRoleMapper
{
    //通过username查找用户角色信息
    List<SysRole> findRoleByUsername(@Param("username") String username);
}
