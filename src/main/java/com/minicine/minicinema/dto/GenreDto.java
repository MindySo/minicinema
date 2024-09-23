package com.minicine.minicinema.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GenreDto {
    private Long genreId;
    private String genreName;
}
