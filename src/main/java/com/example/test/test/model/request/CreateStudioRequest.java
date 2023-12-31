package com.example.test.test.model.request;

public class CreateStudioRequest {

  private String name;
  private String phone;
  private String address;
  private Long userAccountId;

  public CreateStudioRequest(String name, String phone, String address, Long userAccountId) {
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.userAccountId = userAccountId;
  }

  public CreateStudioRequest() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }
}
