package org.jz.service;

import org.jz.model.steam.SteamApi;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */
public interface SteamApiService {

    List<SteamApi> getAllApis();

    boolean delAll();

    void insertSelective(SteamApi steamApi);
}
