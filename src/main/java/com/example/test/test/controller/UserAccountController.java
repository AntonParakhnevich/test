package com.example.test.test.controller;

import com.example.test.test.model.UserAccount;
import com.example.test.test.model.request.CreateUserAccountRequest;
import com.example.test.test.service.UserAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

  private final UserAccountService userAccountService;

  public UserAccountController(UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  @PostMapping("/")
  public String create(@RequestBody CreateUserAccountRequest request) {
    return userAccountService.create(request.getName(), request.getPhone(), request.getRole());
  }

  @GetMapping("/{id}")
  public UserAccount getById(@PathVariable("id") Long id) {
    return userAccountService.getById(id);
  }
}
