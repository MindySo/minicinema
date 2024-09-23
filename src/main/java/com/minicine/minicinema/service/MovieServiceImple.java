package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.GenreDto;
import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImple implements MovieService{
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> selectAll() {
        return movieMapper.selectAll();
    }

    public Page<Map<String, Object>> moviePaging(Pageable pageable) {
        List<MovieDto> movieList = movieMapper.selectAll();
//        RequestList requestList = RequestList.builder()
//                .data(movieList)
//                .pageable(pageable)
//                .build();
        int page = pageable.getPageNumber(); // 페이지 번호
        int pageSize = pageable.getPageSize(); // 페이지 크기
        int offset = page * pageSize; // 계산된 offset 값

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("pageSize", pageSize);
        requestMap.put("offset", offset);

        List<Map<String, Object>> content = movieMapper.moviePaging(requestMap);

        return new PageImpl<>(content, pageable, movieList.size());
    }

    public MovieDto selectOneByMovieId(Long movieId) {
        return movieMapper.selectOneByMovieId(movieId);
    }

    public List<MovieDto> selectByKeyword(String keyword) {
        return movieMapper.selectByKeyword(keyword);
    }

    public List<MovieDto> selectByTitle(String keyword) {
        return movieMapper.selectByTitle(keyword);
    }

    public List<MovieDto> selectByDirector(String keyword) {
        return movieMapper.selectByDirector(keyword);
    }

    public List<MovieDto> selectByActor(String keyword) {
        return movieMapper.selectByActor(keyword);
    }

    public List<MovieDto> selectById(Long id) {
        return movieMapper.selectById(id);
    }

    public List<MovieDto> selectByGenre(List<GenreDto> genreList) {
        List<MovieDto> movieListByGenre = new ArrayList<>();
        Set<Long> existingMovieIds = new HashSet<>(); // 이미 추가된 movieId를 저장할 Set

        for (GenreDto genre : genreList) {
            List<MovieDto> movieList = movieMapper.selectByGenre("%" + genre.getGenreName() + "%");

            for (MovieDto movie : movieList) {
                if (!existingMovieIds.contains(movie.getMovieId())) { // movieId가 Set에 없으면 추가
                    movieListByGenre.add(movie);
                    existingMovieIds.add(movie.getMovieId()); // 추가한 movieId는 Set에 저장
                }
            }
        }
        return movieListByGenre;
    }
}
