package com.example.test.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reply")

public class Reply {
    @Id
    //id가 자동적으로 생성된다고 함. 하지만 이것때문에 절대로 내가 수동으로 id를 설정 불가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "postid", length = 50)
    private Integer postid;
    @Column(name = "text", length = 500)
    private String text;

    public Reply(Integer postid, String text) {
        this.postid = postid;
        this.text = text;
    }

    public Reply() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getPostid() { return postid; }

    public void setPostid(Integer postid) { this.postid = postid; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

}
