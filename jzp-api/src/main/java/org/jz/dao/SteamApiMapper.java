package org.jz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jz.model.steam.SteamApi;

import java.util.List;

@Mapper
public interface SteamApiMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(SteamApi record);

    int insertSelective(SteamApi record);

    SteamApi selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(SteamApi record);

    int updateByPrimaryKeyWithBLOBs(SteamApi record);

    int updateByPrimaryKey(SteamApi record);

    List<SteamApi> getAllApis();

    int delAll();
}