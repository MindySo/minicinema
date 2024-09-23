package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {

        List<MovieDto> selectAll();
        List<Map<String, Object>> moviePaging(Map<String, Object> requestMap);
        MovieDto selectOneByMovieId(Long movieId);
        List<MovieDto> selectByKeyword(String keyword);
        List<MovieDto> selectByTitle(String keyword);
        List<MovieDto> selectByDirector(String keyword);
        List<MovieDto> selectByActor(String keyword);
        List<MovieDto> selectById(Long id);
        List<MovieDto> selectByGenre(String genre);
}
