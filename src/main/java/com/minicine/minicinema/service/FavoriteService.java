package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.FavoriteDto;
import com.minicine.minicinema.dto.auth.TokenDto;
import com.minicine.minicinema.mapper.FavoriteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoriteService {
    public final FavoriteMapper favoriteMapper;

    public boolean ifFavorite(FavoriteDto param) {
        FavoriteDto favoriteDto = favoriteMapper.selectOneByIdAndMovieId(param);
        return favoriteDto != null;
    }

    public void insertFavorite(FavoriteDto favoriteDto) {
        favoriteMapper.insertOne(favoriteDto);
    }

    public void deleteFavorite(FavoriteDto favoriteDto) {
        favoriteMapper.deleteOne(favoriteDto);
    }
}
