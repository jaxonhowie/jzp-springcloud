package org.jz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jz.model.steam.SteamApi;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/11
 */

@Mapper
public interface SteamApiDao {

    List<SteamApi> queryAll();

    void delAll();

    void insertSelective(SteamApi steamApi);

    SteamApi selectByName(String name);

    void updateSelective(SteamApi steamApi);

    List<SteamApi> queryAllIgnoreDel();
}
