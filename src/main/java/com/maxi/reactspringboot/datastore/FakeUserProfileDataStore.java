package com.maxi.reactspringboot.datastore;

import com.maxi.reactspringboot.profile.UserProfile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Maxi", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Jose", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
