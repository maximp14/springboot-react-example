package com.maxi.reactspringboot.controller;

import com.maxi.reactspringboot.entity.UserProfile;
import com.maxi.reactspringboot.service.UserProfileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @ApiOperation( value = "Get all users",
    notes = "Get a list with all users",
    response = UserProfile.class)
    @GetMapping("/users")
    public List<UserProfile> getUsers(){
        return  userProfileService.getUsers();
    }

    @ApiOperation(value = "Save an user",
    notes = "Add an user to the db",
    response = UserProfile.class)
    @PostMapping("/user")
    public void  addUser(@RequestBody UserProfile userProfile){
        userProfileService.addUser(userProfile);
    }

    @ApiOperation(value = "Get one specific user",
    notes = "Given an id you can get the user",
    response = UserProfile.class)
    @GetMapping("/user/{id}")
    public UserProfile getUser(@PathVariable("id") Integer userProfileId){
        return userProfileService.getUser(userProfileId);
    }

    @ApiOperation(value = "Update User",
    notes = "Given an id you can update an user",
    response = UserProfile.class)
    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") Integer userProfileId, @RequestBody UserProfile userProfile){
        userProfileService.updateUser(userProfileId, userProfile);
    }

    @ApiOperation(value = "Delete User",
    notes = "Given an id you can delete an user from the db",
    response = UserProfile.class)
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer userProfileId){
        userProfileService.deleteUser(userProfileId);
    }

}
