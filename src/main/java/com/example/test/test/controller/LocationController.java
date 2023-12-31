package com.example.test.test.controller;

import com.example.test.test.model.request.CreateLocationRequest;
import com.example.test.test.service.LocationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController {

  private final LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping("/")
  public String create(@RequestBody CreateLocationRequest request) {
    return locationService.create(request.getName(), request.getStudioId());
  }
}
