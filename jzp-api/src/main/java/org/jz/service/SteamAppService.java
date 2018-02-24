package org.jz.service;

import org.jz.model.steam.SteamApp;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */

public interface SteamAppService {

    List<SteamApp> queryAll();

    void delAll();

    void insertSelective(SteamApp steamApp);
}
