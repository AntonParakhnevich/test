package com.example.test.test.service;

import com.example.test.test.model.Location;
import com.example.test.test.validator.ExistLocationValidator;
import com.example.test.test.validator.ExistStudioByIdValidator;
import com.example.test.test.validator.NameValidator;
import org.springframework.stereotype.Service;

@Service
public class LocationValidationService implements ValidationService<Location> {

  private final NameValidator nameValidator;
  private final ExistLocationValidator existLocationValidator;
  private final ExistStudioByIdValidator existStudioByIdValidator;

  public LocationValidationService(NameValidator nameValidator, ExistLocationValidator existLocationValidator,
      ExistStudioByIdValidator existStudioByIdValidator) {
    this.nameValidator = nameValidator;
    this.existLocationValidator = existLocationValidator;
    this.existStudioByIdValidator = existStudioByIdValidator;
  }

  @Override
  public String validate(Location location) {
    String nameValidateError = nameValidator.validate(location.getName());
    if (nameValidateError != null) {
      return nameValidateError;
    }
    String existLocationValidateError = existLocationValidator.validate(location);
    if (existLocationValidateError != null) {
      return existLocationValidateError;
    }
    String existStudioValidateError = existStudioByIdValidator.validate(location.getStudioId());
    if (existStudioValidateError != null) {
      return existStudioValidateError;
    }
    return null;
  }
}
