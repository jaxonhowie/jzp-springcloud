package org.jz.service.impl;

import org.jz.dao.SteamAppDao;
import org.jz.model.steam.SteamApp;
import org.jz.service.SteamAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/24
 */


@Service("steamAppService")
public class SteamAppServiceImpl implements SteamAppService {

    @Autowired
    SteamAppDao steamAppDao;

    @Override
    public List<SteamApp> queryAll() {
        return steamAppDao.queryAll();
    }

    @Override
    public void delAll() {
        steamAppDao.delAll();
    }

    @Override
    public void insertSelective(SteamApp steamApp) {
        steamAppDao.insertSelective(steamApp);
    }
}
