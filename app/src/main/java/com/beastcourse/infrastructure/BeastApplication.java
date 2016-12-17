package com.beastcourse.infrastructure;

import android.app.Application;

import com.beastcourse.live.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

import lombok.Getter;

public class BeastApplication extends Application {

    @Getter private Bus bus;

    public static final String YOUTUBE_API_KEY = "AIzaSyAEak8YzYMohi3RqbP_x1YmRT4IedkbAQc";
    public static final String FIRE_BASE_BROTHER_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/brothers";

    public static final String FIRE_BASE_EVENT_CARDS_COMMUNITY_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventCards/community";
    public static final String FIRE_BASE_EVENT_CARDS_BROTHERHOOD_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventCards/brotherHood";
    public static final String FIRE_BASE_EVENT_CARDS_SOCIAL_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventCards/social";

    public static final String FIRE_BASE_EVENT_PHOTOS_COMMUNITY_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventPics/community";
    public static final String FIRE_BASE_EVENT_PHOTOS_BROTHERHOOD_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventPics/brotherHood";
    public static final String FIRE_BASE_EVENT_PHOTOS_SOCIAL_REFERENCE = "https://brotherhood-151719.firebaseio.com/data/eventPics/social";

    public static final String FIRE_BASE_RUSH_EVENTS_COMMUNITY = "https://brotherhood-151719.firebaseio.com/data/rushEvents/service";
    public static final String FIRE_BASE_RUSH_EVENTS_SOCIAL = "https://brotherhood-151719.firebaseio.com/data/rushEvents/socials";

    public BeastApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.register(this);
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
