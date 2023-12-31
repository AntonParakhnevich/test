package com.example.test.test.model.request;

import com.example.test.test.model.Role;

public class CreateUserAccountRequest {

  private String name;
  private String phone;
  private Role role;

  public CreateUserAccountRequest(String name, String phone, Role role) {
    this.name = name;
    this.phone = phone;
    this.role = role;
  }

  public CreateUserAccountRequest() {
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
