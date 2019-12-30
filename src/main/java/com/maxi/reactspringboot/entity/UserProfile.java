package com.maxi.reactspringboot.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userProfileId;

  @NotBlank
  @Column(name = "user_name")
  private String username;

  @NotBlank
  @Column(name = "user_profile_image")
  private String userProfileImage;

  public UserProfile(Integer id, String username, String userProfileImage) {
    this.userProfileId = id;
    this.username = username;
    this.userProfileImage = userProfileImage;
  }

  public Integer getUserProfileId() {
    return userProfileId;
  }

  public String getUsername() {
    return username;
  }

  public String getUserProfileImage() {
    return userProfileImage;
  }

  public void setUserProfileId(Integer userProfileId) {
    this.userProfileId = userProfileId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setUserProfileImage(String userProfileImage) {
    this.userProfileImage = userProfileImage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfile that = (UserProfile) o;
    return userProfileId.equals(that.userProfileId) &&
        username.equals(that.username) &&
        userProfileImage.equals(that.userProfileImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userProfileId, username, userProfileImage);
  }
}
