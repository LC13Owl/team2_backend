package com.example.test.dto;

public class    DtoExceptContent {
    private Integer id;
    private String title;
    
    // 이 생성자가 필수로 있어야 작동 가능함.(필드가 있다고 말만 했을 뿐, 그것을 실제로 파라미터로 가질 수 있는 형식을 여기서 말하는 것, 그것이 생성자)
    public DtoExceptContent(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    // 아무 파라미터 없는 기본 생성자, DtoExceptContent dto = new DtoExceptContent(); 이런 식으로 쓸 때 필요함
    public DtoExceptContent() {

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
}