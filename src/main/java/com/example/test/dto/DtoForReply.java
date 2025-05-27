package com.example.test.dto;

public class DtoForReply {
    private Integer id;
    private Integer postid;
    private String text;

    // 이 생성자가 필수로 있어야 작동 가능함.(필드가 있다고 말만 했을 뿐, 그것을 실제로 파라미터로 가질 수 있는 형식을 여기서 말하는 것, 그것이 생성자)
    public DtoForReply(Integer id, String title, Integer pin) {
        this.id = id;
        this.postid = postid;
        this.text = text;
    }

    // 아무 파라미터 없는 기본 생성자, DtoExceptContent dto = new DtoExceptContent(); 이런 식으로 쓸 때 필요함
    public DtoForReply() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }
}