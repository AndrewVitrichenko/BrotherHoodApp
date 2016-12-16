package com.beastcourse.live;

import com.beastcourse.infrastructure.BeastApplication;


public class Module {

    public static void register(BeastApplication application){
        new LiveBrotherService(application);
        new LiveCardsService(application);
        new LivePictureService(application);
        new LiveRushEventsService(application);
    }
}
