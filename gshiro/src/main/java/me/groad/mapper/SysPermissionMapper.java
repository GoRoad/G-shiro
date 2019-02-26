package me.groad.mapper;

import me.groad.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @BelongsProject: gshiro
 * @BelongsPackage: me.groad.mapper
 * @Author: Groad
 * @CreateTime: 2019-02-26 16:30
 * @Description: 权限mapper接口, 一个角色对应多个权限
 * @Version: 1.0
 */
@Component
public interface SysPermissionMapper
{
    //根据角色ID查询角色对应的权限信息
    List<SysPermission> findPermissionByRoleId(@Param("releId") Integer roleId);
}
