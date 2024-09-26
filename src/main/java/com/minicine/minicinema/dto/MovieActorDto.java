package com.minicine.minicinema.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieActorDto {
    private Long movieActorId;
    private Long movieId;
    private Long actorId;

}
