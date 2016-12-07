package com.beastcourse.infrastructure;

import android.app.Application;

import com.beastcourse.inmemory.Module;
import com.squareup.otto.Bus;

import lombok.Getter;

/**
 * Created by Andrey on 02.10.2016.
 */

public class BeastApplication extends Application {

    @Getter private Bus bus;

    public static final String YOUTUBE_API_KEY = "AIzaSyAEak8YzYMohi3RqbP_x1YmRT4IedkbAQc";

    public BeastApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.register(this);
    }
}
