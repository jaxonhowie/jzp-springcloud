package org.jz.service.impl;

import org.jz.dao.SteamApiDao;
import org.jz.model.steam.SteamApi;
import org.jz.service.SteamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */

@Service("steamApiService")
public class SteamApiServiceImpl implements SteamApiService{

    @Autowired
    SteamApiDao steamApiDao;

    @Override
    public List<SteamApi> queryAll() {
        return steamApiDao.queryAll();
    }

    @Override
    public void delAll() {
        steamApiDao.delAll();
    }

    @Override
    public void insertSelective(SteamApi steamApi) {
        steamApiDao.insertSelective(steamApi);
    }
}
