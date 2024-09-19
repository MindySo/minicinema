package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.mapper.movie.MovieMapper;
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
}
