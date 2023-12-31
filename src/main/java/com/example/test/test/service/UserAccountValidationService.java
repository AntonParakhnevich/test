package com.example.test.test.service;

import com.example.test.test.model.UserAccount;
import com.example.test.test.validator.NameValidator;
import com.example.test.test.validator.UserPhoneValidator;
import org.springframework.stereotype.Service;

@Service
public class UserAccountValidationService implements ValidationService<UserAccount> {

  private final UserPhoneValidator userPhoneValidator;
  private final NameValidator nameValidator;

  public UserAccountValidationService(UserPhoneValidator userPhoneValidator, NameValidator nameValidator) {
    this.userPhoneValidator = userPhoneValidator;
    this.nameValidator = nameValidator;
  }

  @Override
  public String validate(UserAccount userAccount) {
    String nameValidateError = nameValidator.validate(userAccount.getName());
    if (nameValidateError != null) {
      return nameValidateError;
    }
    String phoneValidateError = userPhoneValidator.validate(userAccount.getPhone());
    if (phoneValidateError != null) {
      return phoneValidateError;
    }
    return null;
  }
}
