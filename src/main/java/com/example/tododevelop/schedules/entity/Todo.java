package com.example.tododevelop.schedules.entity;

import com.example.tododevelop.entity.BaseEntity;
import com.example.tododevelop.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;


@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne //연관 관계 설정
    @JoinColumn(name = "users_id")
    private Users users;

    public Todo() {
    }

    public Todo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public void updateContents(String newContents) {
        this.contents = newContents;
    }
}
