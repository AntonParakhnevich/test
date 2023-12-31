package com.example.test.test.validator;

import com.example.test.test.model.Location;
import com.example.test.test.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class ExistLocationValidator implements Validator<Location> {

  private final LocationRepository locationRepository;

  public ExistLocationValidator(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  @Override
  public String validate(Location location) {
    Integer countByNameAndStudioId = locationRepository.countByNameAndStudioId(location.getName(),
        location.getStudioId());
    if (countByNameAndStudioId > 0) {
      return "Локация с данным именем для студии=" + location.getStudioId() + " уже зарегистрирована";
    }
    return null;
  }
}
