package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {
//        void save(@Param("movie") MovieDto movieDto);
        List<MovieDto> selectAll();
        MovieDto selectOneByMovieId(Long movieId);
}
