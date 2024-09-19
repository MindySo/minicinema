package com.minicine.minicinema.mapper.movie;

import com.minicine.minicinema.dto.MovieDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
//        void save(@Param("movie") MovieDto movieDto);
        List<MovieDto> selectAll();
}
