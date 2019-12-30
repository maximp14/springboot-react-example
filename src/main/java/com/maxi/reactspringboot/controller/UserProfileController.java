package com.maxi.reactspringboot.controller;

import com.maxi.reactspringboot.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
public class UserProfileController {

  private final UserProfileService userProfileService;

  @Autowired
  public UserProfileController(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }


}
