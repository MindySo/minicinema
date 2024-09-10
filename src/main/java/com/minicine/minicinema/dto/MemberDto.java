package com.minicine.minicinema.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String role;
}
