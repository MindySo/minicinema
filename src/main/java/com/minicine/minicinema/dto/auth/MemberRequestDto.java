package com.minicine.minicinema.dto.auth;

import com.minicine.minicinema.common.AuthorityEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Schema(title = "AUTH_REQ_01 : 로그인 요청 DTO")
public class MemberRequestDto {

    @NotNull(message = "id 입력은 필수입니다.")
    private String username;

    @NotNull(message = "패스워드 입력은 필수입니다.")
    private String password;

    private AuthorityEnum authority;
}