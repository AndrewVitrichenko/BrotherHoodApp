package com.beastcourse.live;

import com.beastcourse.entities.RushEvent;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.RushEventService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Andrey on 12.12.2016.
 */

public class LiveRushEventsService extends BaseLiveService {

    public LiveRushEventsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getCommunityRushEvents(RushEventService.SearchRushEventsCommunityRequest request){
        RushEventService.SearchRushEventsCommunityResponse response = new RushEventService.SearchRushEventsCommunityResponse();
        response.communityRushEvents = new ArrayList<>();
        response.communityRushEvents.add(new RushEvent(
                1,"CommunityEvent 1",
                "09/05/2016",
                "8:00pm",
                "Mu 202",
                "This is the description of community event 1",
                2.2,
                2.2,
                true
        ));
        bus.post(response);
    }

    @Subscribe
    public void getSocialRushEvents(RushEventService.SearchRushEventsSocialRequest request){
        RushEventService.SearchRushEventsSocialResponse response = new RushEventService.SearchRushEventsSocialResponse();
        response.socialRushEvents = new ArrayList<>();
        response.socialRushEvents.add(new RushEvent(
                1,"Social Event 1",
                "09/05/2016",
                "8:00pm",
                "Bourbon Street",
                "This is the description of social event 1",
                29.959472,
                -90.064894,
                false
        ));
        bus.post(response);
    }
}
