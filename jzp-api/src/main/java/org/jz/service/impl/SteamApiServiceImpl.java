package org.jz.service.impl;

import org.jz.dao.SteamApiMapper;
import org.jz.model.steam.SteamApi;
import org.jz.service.SteamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hongyi Zheng
 * @date 2018/2/9
 */

@Service("steamApiServiceImpl")
public class SteamApiServiceImpl implements SteamApiService{

    @Autowired
    SteamApiMapper steamApiMapper;

    @Override
    public List<SteamApi> getAllApis() {
        return steamApiMapper.getAllApis();
    }

    @Override
    public boolean delAll() {
        return steamApiMapper.delAll()>0?true:false;
    }

    @Override
    public void insertSelective(SteamApi steamApi) {
        steamApiMapper.insertSelective(steamApi);
    }
}
