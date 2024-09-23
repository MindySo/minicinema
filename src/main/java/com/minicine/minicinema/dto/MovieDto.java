package com.minicine.minicinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieDto {
    private Long movieId;
    private String title;
    private String age;
    private String country;
    private String runningTime;
    private LocalDate releaseDate;
    private String productionCompany;
    private String plot;
    private String img;

    private String directorName;
}
