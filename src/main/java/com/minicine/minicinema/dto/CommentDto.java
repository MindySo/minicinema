package com.minicine.minicinema.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString @Slf4j @Builder
public class CommentDto {
    private String id;
    private Long memberId;
    private Long movieId;
    private String nickname;
    private String content;
    private LocalDateTime regDate;
}
