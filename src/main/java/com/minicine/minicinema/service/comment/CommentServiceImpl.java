package com.minicine.minicinema.service.comment;

import com.minicine.minicinema.dto.CommentDto;
import com.minicine.minicinema.entity.comment.CommentEntity;
import com.minicine.minicinema.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public void insertComment(CommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity(
                commentDto.getId(),
                commentDto.getMemberId(),
                commentDto.getMovieId(),
                commentDto.getContent(),
                commentDto.getRegDate()
        );
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentDto> selectAllByMovieId(Long movieId) {
        return commentRepository.findAllByMovieId(movieId);
    }
}
