package com.sx.dao;

import com.sx.pojo.FavKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavMapper {
    int deleteByPrimaryKey(FavKey key);

    int insert(FavKey record);

    int insertSelective(FavKey record);

    List<FavKey> selectByUid(String uid);

    List<FavKey> selectByCarId(String carId);
}