package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.GenreDto;
import com.minicine.minicinema.dto.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MovieService {
    List<MovieDto> selectAll();
    Page<Map<String, Object>> moviePaging(Pageable pageable) ;
    MovieDto selectOneByMovieId(Long movieId) ;
    List<MovieDto> selectByKeyword(String keyword) ;
    List<MovieDto> selectByTitle(String keyword) ;
    List<MovieDto> selectByDirector(String keyword) ;
    List<MovieDto> selectByActor(String keyword) ;
    List<MovieDto> selectById(Long id) ;
    List<MovieDto> selectByGenre(List<GenreDto> genreList) ;
}
