package com.minicine.minicinema.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieGenreDto {
    private Long movieGenreId;
    private Long movieId;
    private Long genreId;
}
