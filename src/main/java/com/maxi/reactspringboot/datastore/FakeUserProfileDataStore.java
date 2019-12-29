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
        USER_PROFILES.add(
            new UserProfile(UUID.fromString("27e59a67-1c96-4f8f-b1fa-51d2790d9e6f"), "Maxi", null));
        USER_PROFILES.add(
            new UserProfile(UUID.fromString("d08f179f-1e7e-4cdc-8237-2672b066b7ea"), "Jose", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
