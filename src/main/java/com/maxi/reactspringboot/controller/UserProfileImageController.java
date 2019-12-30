package com.maxi.reactspringboot.controller;

import com.maxi.reactspringboot.entity.UserProfile;
import com.maxi.reactspringboot.service.UserProfileImageService;
import com.maxi.reactspringboot.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
public class UserProfileImageController {

    private final UserProfileImageService userProfileImageService;


    @Autowired
    public UserProfileImageController(UserProfileImageService userProfileImageService) {
        this.userProfileImageService = userProfileImageService;
    }

    @PostMapping(
            path = "{userProfileId}/image/upload",
            consumes = MULTIPART_FORM_DATA_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") Integer userProfileId,
                                       @RequestParam("file") MultipartFile file) {
        userProfileImageService.uploadUserProfileImage(userProfileId, file);
    }

    @GetMapping("{userProfileId}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") Integer userProfileId) {
        return userProfileImageService.downloadUserProfileImage(userProfileId);
    }


}
