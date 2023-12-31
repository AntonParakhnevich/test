package com.example.test.test.service;

import com.example.test.test.model.Studio;
import com.example.test.test.repository.StudioRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService {

  private final StudioRepository studioRepository;
  private final StudioValidationService studioValidationService;

  public StudioService(StudioRepository studioRepository, StudioValidationService studioValidationService) {
    this.studioRepository = studioRepository;
    this.studioValidationService = studioValidationService;
  }

  public String create(String name, String address, String phone, Long userAccountId) {
    Studio studio = new Studio();
    studio.setName(name);
    studio.setPhone(phone);
    studio.setAddress(address);
    studio.setUserAccountId(userAccountId);

    String validateErrorMessage = studioValidationService.validate(studio);
    if (validateErrorMessage != null) {
      return validateErrorMessage;
    }

    studioRepository.save(studio);
    return "success";
  }
}
