package dao;

import model.Api;

public interface ApiMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Api record);

    int insertSelective(Api record);

    Api selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Api record);

    int updateByPrimaryKeyWithBLOBs(Api record);

    int updateByPrimaryKey(Api record);
}