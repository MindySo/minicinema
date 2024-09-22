package com.minicine.minicinema.service.comment;

import com.minicine.minicinema.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    void insertComment(CommentDto commentDto);
    void deleteComment(String commentId);
    List<CommentDto> selectAllByMovieId(Long movieId);
}
