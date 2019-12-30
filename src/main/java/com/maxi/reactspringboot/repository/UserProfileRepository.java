package com.maxi.reactspringboot.repository;

import com.maxi.reactspringboot.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
