package org.jz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.jz.model.steam.SteamApp;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */
@Mapper
public interface SteamAppDao {
    List<SteamApp> queryAll();

    void delAll();

    void insertSelective(SteamApp steamApi);
}
