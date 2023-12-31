package com.example.test.test.model.request;

public class CreateLocationRequest {

  private String name;
  private Long studioId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getStudioId() {
    return studioId;
  }

  public void setStudioId(Long studioId) {
    this.studioId = studioId;
  }
}
