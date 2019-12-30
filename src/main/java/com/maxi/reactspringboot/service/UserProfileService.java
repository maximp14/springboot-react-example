package com.maxi.reactspringboot.service;


import com.maxi.reactspringboot.entity.UserProfile;
import java.util.List;

public interface UserProfileService {

  List<UserProfile> getUsers();

  UserProfile getUser(Integer id);

  void addUser(UserProfile userProfile);

  void updateUser(Integer id, UserProfile userProfile);

  void deleteUser(Integer id);

}
