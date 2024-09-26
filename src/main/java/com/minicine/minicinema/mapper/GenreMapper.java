package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.GenreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {
    List<GenreDto> selectAllByMovieId(Long movieId);
}
