package com.example.test.test.service;

import com.example.test.test.model.Location;
import com.example.test.test.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  private final LocationRepository locationRepository;
  private final LocationValidationService locationValidationService;

  public LocationService(LocationRepository locationRepository, LocationValidationService locationValidationService) {
    this.locationRepository = locationRepository;
    this.locationValidationService = locationValidationService;
  }

  public String create(String name, Long studioId) {
    Location location = new Location();
    location.setName(name);
    location.setStudioId(studioId);

    String validateErrorMessage = locationValidationService.validate(location);
    if (validateErrorMessage != null) {
      return validateErrorMessage;
    }

    locationRepository.save(location);
    return "success";
  }
}
