package com.example.test.test.service;

import com.example.test.test.model.Role;
import com.example.test.test.model.UserAccount;
import com.example.test.test.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

  private final UserAccountRepository repository;
  private final UserAccountValidationService userAccountValidationService;

  public UserAccountService(UserAccountRepository repository,
      UserAccountValidationService userAccountValidationService) {
    this.repository = repository;
    this.userAccountValidationService = userAccountValidationService;
  }

  public String create(String name, String phone, Role role) {
    UserAccount userAccount = new UserAccount();
    userAccount.setName(name);
    userAccount.setPhone(phone);
    userAccount.setRole(role);

    String validateErrorMessage = userAccountValidationService.validate(userAccount);
    if (validateErrorMessage != null) {
      return validateErrorMessage;
    }

    repository.save(userAccount);
    return "success";
  }

  public UserAccount getById(Long id) {
    return repository.findById(id)
        .orElse(null);
  }
}
