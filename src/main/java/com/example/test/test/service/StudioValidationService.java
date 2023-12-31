package com.example.test.test.service;

import com.example.test.test.model.Studio;
import com.example.test.test.validator.ExistStudioByPhoneAndNameValidator;
import com.example.test.test.validator.ExistUserAccountValidator;
import com.example.test.test.validator.NameValidator;
import com.example.test.test.validator.PhoneFormatValidator;
import org.springframework.stereotype.Service;

@Service
public class StudioValidationService implements ValidationService<Studio> {

  private final ExistStudioByPhoneAndNameValidator existStudioValidator;
  private final NameValidator nameValidator;
  private final ExistUserAccountValidator existUserAccountValidator;
  private final PhoneFormatValidator phoneFormatValidator;

  public StudioValidationService(ExistStudioByPhoneAndNameValidator existStudioValidator, NameValidator nameValidator,
      ExistUserAccountValidator existUserAccountValidator, PhoneFormatValidator phoneFormatValidator) {
    this.existStudioValidator = existStudioValidator;
    this.nameValidator = nameValidator;
    this.existUserAccountValidator = existUserAccountValidator;
    this.phoneFormatValidator = phoneFormatValidator;
  }

  @Override
  public String validate(Studio studio) {
    String nameValidateError = nameValidator.validate(studio.getName());
    if (nameValidateError != null) {
      return nameValidateError;
    }
    String phoneFormatValidateError = phoneFormatValidator.validate(studio.getPhone());
    if (phoneFormatValidateError != null) {
      return phoneFormatValidateError;
    }
    String existStudioValidateError = existStudioValidator.validate(studio);
    if (existStudioValidateError != null) {
      return existStudioValidateError;
    }
    String userAccountValidateError = existUserAccountValidator.validate(studio.getUserAccountId());
    if (userAccountValidateError != null) {
      return userAccountValidateError;
    }
    return null;
  }
}
