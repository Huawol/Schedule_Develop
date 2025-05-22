package com.example.tododevelop.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createAt; // 생성 시간

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime modifiedAt; // 수정 시간
}
