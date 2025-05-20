package com.example.test.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")

public class BoardEntity {
    @Id
    //id가 자동적으로 생성된다고 함. 하지만 이것때문에 절대로 내가 수동으로 id를 설정 불가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 500)
    private String content;

    @CreationTimestamp  // 생성 시각 자동 입력
    private LocalDateTime createdAt;

    public BoardEntity( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BoardEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

