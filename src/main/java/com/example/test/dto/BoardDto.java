package com.example.test.dto;

// 데이터 전송의 역할, 비지니스 로직 없음,

import java.time.LocalDateTime;

public class BoardDto {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Integer pin;
    private Integer good;

    public BoardDto( String title, String content, LocalDateTime createdAt) {
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.pin = pin;
    this.good = good;
    }

    public BoardDto() {

    }

    public int getId() {
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

    public LocalDateTime getCreatedAt() {return createdAt;}

    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public Integer getPin() {return pin;}

    public void setPin(Integer pin) {this.pin = pin;}

    public Integer getGood() {return good;}

    public void setGood(Integer good) {this.good = good;}
}