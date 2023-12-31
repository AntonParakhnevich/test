package com.example.test.test.validator;

import com.example.test.test.model.Studio;
import com.example.test.test.repository.StudioRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExistStudioByIdValidator implements Validator<Long> {

  private final StudioRepository studioRepository;

  public ExistStudioByIdValidator(StudioRepository studioRepository) {
    this.studioRepository = studioRepository;
  }

  @Override
  public String validate(Long id) {
    if (id == null) {
      return "ExistStudioByIdValidator id is null";
    }
    Optional<Studio> studio = studioRepository.findById(id);
    if (studio.isEmpty()) {
      return "Studio with id=" + id + " isn't exist";
    }
    return null;
  }
}
