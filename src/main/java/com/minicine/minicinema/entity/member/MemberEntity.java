package com.minicine.minicinema.entity.member;

import com.minicine.minicinema.common.AuthorityEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username; // email

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private AuthorityEnum authority;

    @Builder
    public MemberEntity(String username, String password, AuthorityEnum authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }
}
