package com.minicine.minicinema.dto.auth;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private int errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;
}