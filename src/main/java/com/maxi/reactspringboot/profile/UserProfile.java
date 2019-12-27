package com.maxi.reactspringboot.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private UUID userProfileId;
    private String username;
    private String userProfileImage; // S3 key

    public UserProfile(UUID userProfileId, String username, String userProfileImage) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileImage = userProfileImage;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getUserProfileImage() {
        return Optional.ofNullable(userProfileImage);
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userProfileImage, that.userProfileImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userProfileImage);
    }
}
