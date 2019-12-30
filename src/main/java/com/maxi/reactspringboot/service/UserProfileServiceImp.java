package com.maxi.reactspringboot.service;

import com.maxi.reactspringboot.entity.UserProfile;
import com.maxi.reactspringboot.repository.UserProfileRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImp implements UserProfileService {

  private final UserProfileRepository userProfileRepository;

  @Autowired
  public UserProfileServiceImp(
      UserProfileRepository userProfileRepository) {
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  public List<UserProfile> getUsers() {
    List<UserProfile> userProfiles = new ArrayList<>();
    userProfileRepository.findAll().forEach(userProfiles::add);
    return userProfiles;
  }

  @Override
  public UserProfile getUser(Integer id) {
    return userProfileRepository.findById(id).orElseThrow(() ->
        new NoSuchElementException("User" +id+ "not found"));
  }

  @Override
  public void addUser(UserProfile userProfile) {
      userProfileRepository.save(userProfile);
  }

  @Override
  public void updateUser(Integer id, UserProfile userProfile) {
    UserProfile userProfile1 = getUser(id);
    if (userProfile1 != null){
      userProfile1.setUserProfileId(id);
      userProfile1.setUsername(userProfile.getUsername());
      userProfile1.setUserProfileImage(userProfile.getUserProfileImage());
      userProfileRepository.save(userProfile1);
    }
  }

  @Override
  public void deleteUser(Integer id) {
    userProfileRepository.deleteById(id);
  }
}
