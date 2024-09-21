package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieMapper movieMapper;

//    public void addMember(MemberVO memberVO) {
//        memberMapper.save(memberVO);
//    }

    public List<MovieDto> selectAll() {
        return movieMapper.selectAll();
    }
    public MovieDto selectOneByMovieId(Long movieId) {
        return movieMapper.selectOneByMovieId(movieId);
    }
    public List<MovieDto> selectByKeyword(String keyword) { return movieMapper.selectByKeyword(keyword);}
    public List<MovieDto> selectByTitle(String keyword) { return movieMapper.selectByTitle(keyword);}
    public List<MovieDto> selectByDirector(String keyword) { return movieMapper.selectByDirector(keyword);}
    public List<MovieDto> selectByActor(String keyword) { return movieMapper.selectByActor(keyword);}

}
