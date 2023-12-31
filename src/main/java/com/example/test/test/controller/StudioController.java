package com.example.test.test.controller;

import com.example.test.test.model.request.CreateStudioRequest;
import com.example.test.test.service.StudioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studios")
public class StudioController {

  private final StudioService studioService;

  public StudioController(StudioService studioService) {
    this.studioService = studioService;
  }

  @PostMapping("/")
  public String create(@RequestBody CreateStudioRequest request) {
    return studioService.create(request.getName(), request.getAddress(), request.getPhone(),
        request.getUserAccountId());
  }
}
