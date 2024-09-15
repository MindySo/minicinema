package com.minicine.minicinema.dto;

import com.minicine.minicinema.dto.member.MemberDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserInfoDto extends MemberDto {
    private Long id;
    private String username;
    private String password;
    private String role;

}