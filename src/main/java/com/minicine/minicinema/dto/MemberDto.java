package com.minicine.minicinema.dto;

import com.minicine.minicinema.entity.MemberEntity;
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
    private String nickname;
    private String role;

    public static MemberDto toDto(MemberEntity entity) {
        if (entity == null) { return null; }

        return new MemberDto(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getAuthority().toString()
        );
    }
}
