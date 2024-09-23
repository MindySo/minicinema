package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {

        List<MovieDto> selectAll();
        List<Map<String, Object>> selectAllPaging(Map<String, Object> requestMap);

        MovieDto selectOneByMovieId(Long movieId);

        List<MovieDto> selectByKeyword(String keyword);
        List<Map<String, Object>> selectByKeywordPaging(Map<String, Object> requestMap);

        List<MovieDto> selectByTitle(String keyword);
        List<Map<String, Object>> selectByTitlePaging(Map<String, Object> requestMap);

        List<MovieDto> selectByDirector(String keyword);
        List<Map<String, Object>> selectByDirectorPaging(Map<String, Object> requestMap);

        List<MovieDto> selectByActor(String keyword);
        List<Map<String, Object>> selectByActorPaging(Map<String, Object> requestMap);

        List<MovieDto> selectById(Long id);
        List<MovieDto> selectByGenre(String genre);
}
