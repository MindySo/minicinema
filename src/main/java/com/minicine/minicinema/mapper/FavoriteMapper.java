package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.FavoriteDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface FavoriteMapper {
    FavoriteDto selectOneByIdAndMovieId(FavoriteDto favoriteDto);
    void insertOne(FavoriteDto favoriteDto);
    void deleteOne(FavoriteDto favoriteDto);
}
