package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.ActorDto;
import com.minicine.minicinema.mapper.ActorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActorService {
    private final ActorMapper actorMapper;

    public List<ActorDto> selectAllByMovieId(Long movieId) {
        return actorMapper.selectAllByMovieId(movieId);
    }
}
