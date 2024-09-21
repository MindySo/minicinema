package com.minicine.minicinema.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FavoriteDto {
    private Long favoriteId;
    private Long movieId;
    private Long id;

    FavoriteDto(Long movieId){
        this.movieId = movieId;
    }

    FavoriteDto(Long movieId, Long id){
        this.movieId = movieId;
        this.id = id;
    }
}
