package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
//        void save(@Param("movie") MovieDto movieDto);
        List<MovieDto> selectAll();
        MovieDto selectOneByMovieId(Long movieId);
        List<MovieDto> selectByKeyword(String keyword);
        List<MovieDto> selectByTitle(String keyword);
        List<MovieDto> selectByDirector(String keyword);
        List<MovieDto> selectByActor(String keyword);
        List<MovieDto> selectById(Long id);
}
