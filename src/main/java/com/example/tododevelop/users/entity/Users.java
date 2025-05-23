package com.example.tododevelop.users.entity;

import com.example.tododevelop.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "이메일을 입력해주세요!!!")
    @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$")
    @Column(nullable = false, unique = true) // 유일해야하기 때문
    private String userEmail;


    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    public Users() {
    }

    public Users(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }


    public void updatePassword(String password) {
        this.userPassword = password;
    }
}
