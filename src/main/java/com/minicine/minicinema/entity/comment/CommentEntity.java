package com.minicine.minicinema.entity.comment;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentEntity {
    @Id
    private String id;
    private Long memberId;
    private Long movieId;
    private String nickname;
    private String content;
    private LocalDateTime regDate;


}
