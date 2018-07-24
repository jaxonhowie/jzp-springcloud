package org.jz.service;

import org.jz.model.steam.SteamApi;
import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
public interface SteamApiService {

    List<SteamApi> queryAll();

    void delAll();

    void insertSelective(SteamApi steamApi);

    SteamApi selectByName(String name);

    void updateSelective(SteamApi steamApi);

    List<SteamApi> queryAllIgnoreDel();
}
