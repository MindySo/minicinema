package com.minicine.minicinema.repository.comment;

import com.minicine.minicinema.dto.CommentDto;
import com.minicine.minicinema.entity.comment.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<CommentEntity, String> {
    List<CommentDto> findAllByMovieId(Long movieId);
}
