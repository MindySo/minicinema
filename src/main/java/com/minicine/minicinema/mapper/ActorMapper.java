package com.minicine.minicinema.mapper;

import com.minicine.minicinema.dto.ActorDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    List<ActorDto> selectAllByMovieId(Long movieId);
}
