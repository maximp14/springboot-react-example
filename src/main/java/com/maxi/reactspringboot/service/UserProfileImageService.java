package com.maxi.reactspringboot.service;

import static com.maxi.reactspringboot.bucket.BucketName.*;
import static org.apache.http.entity.ContentType.IMAGE_GIF;
import static org.apache.http.entity.ContentType.IMAGE_JPEG;
import static org.apache.http.entity.ContentType.IMAGE_PNG;
import static org.apache.http.entity.ContentType.IMAGE_WEBP;

import com.maxi.reactspringboot.bucket.BucketName;
import com.maxi.reactspringboot.entity.UserProfile;
import com.maxi.reactspringboot.filestore.FileStore;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserProfileImageService {

  private final FileStore fileStore;
  private final UserProfileService userProfileService;

  @Autowired
  public UserProfileImageService(FileStore fileStore,
      UserProfileService userProfileService) {
    this.fileStore = fileStore;
    this.userProfileService = userProfileService;
  }

  public void uploadUserProfileImage(Integer userProfileId, MultipartFile file) {

    isFileEmpty(file);
    isImage(file);
    UserProfile user = getUserProfileOrThrow(userProfileId);

    Map<String, String> metadata = extractMetaData(file);

    String path = String
        .format("%s/%s", PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
    String filename = String.format("%s-%s", file.getOriginalFilename(), user.getUserProfileId());

    try {
      fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
      user.setUserProfileImage(filename);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }

  public byte[] downloadUserProfileImage(Integer userProfileId) {
    UserProfile user = getUserProfileOrThrow(userProfileId);

    String path = String
        .format("%s/%s", PROFILE_IMAGE.getBucketName(), user.getUserProfileId());

//    return user.getUserProfileImage()
//        .map(key -> fileStore.download(path, key))
//        .orElse(new byte[0]);

  }



  private void isFileEmpty(MultipartFile file) {
    if (file.isEmpty()){
      throw new IllegalStateException("you cannot upload an empty file");
    }
  }

  private void isImage(MultipartFile file) {
    if (!Arrays
        .asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_WEBP.getMimeType(),
            IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
      throw new IllegalStateException("file not support" + file.getContentType());
    }
  }

  private UserProfile getUserProfileOrThrow(Integer userProfileId) {
    return userProfileService.getUsers().stream()
        .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException(
            String.format("User profile %s not found", userProfileId)));
  }

  private Map<String, String> extractMetaData(MultipartFile file) {
    Map<String, String> metadata = new HashMap<>();
    metadata.put("Content-Type", file.getContentType());
    metadata.put("Content-Length",String.valueOf(file.getSize()));
    return metadata;
  }

}
