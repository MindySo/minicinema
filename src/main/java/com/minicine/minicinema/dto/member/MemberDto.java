package com.minicine.minicinema.dto.member;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String role;
}
