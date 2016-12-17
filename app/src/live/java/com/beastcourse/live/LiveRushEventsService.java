package com.beastcourse.live;

import com.beastcourse.entities.RushEvent;
import com.beastcourse.entities.firebaseEntities.RushEventFireBase;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.RushEventService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LiveRushEventsService extends BaseLiveService {

    public LiveRushEventsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getCommunityRushEvents(RushEventService.SearchRushEventsCommunityRequest request) {
        final RushEventService.SearchRushEventsCommunityResponse response = new RushEventService.SearchRushEventsCommunityResponse();
        response.communityRushEvents = new ArrayList<>();
        Firebase reference = new Firebase(request.firebaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                RushEventFireBase rushEventFireBase;
                RushEvent rushEvent;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    rushEventFireBase = dataSnapshot1.getValue(RushEventFireBase.class);

                    rushEvent = new RushEvent(
                            index,
                            rushEventFireBase.getName(),
                            rushEventFireBase.getDate(),
                            rushEventFireBase.getTime(),
                            rushEventFireBase.getLocation(),
                            rushEventFireBase.getDescription(),
                            rushEventFireBase.getLatitude(),
                            rushEventFireBase.getLongitude(),
                            rushEventFireBase.isCampus()
                    );

                    response.communityRushEvents.add(rushEvent);
                    index++;
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Subscribe
    public void getSocialRushEvents(RushEventService.SearchRushEventsSocialRequest request) {
        final RushEventService.SearchRushEventsSocialResponse response = new RushEventService.SearchRushEventsSocialResponse();
        response.socialRushEvents = new ArrayList<>();
        Firebase reference = new Firebase(request.firebaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;

                RushEventFireBase rushEventFireBase;
                RushEvent rushEvent;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    rushEventFireBase = dataSnapshot1.getValue(RushEventFireBase.class);

                    rushEvent = new RushEvent(
                            index,
                            rushEventFireBase.getName(),
                            rushEventFireBase.getDate(),
                            rushEventFireBase.getTime(),
                            rushEventFireBase.getLocation(),
                            rushEventFireBase.getDescription(),
                            rushEventFireBase.getLatitude(),
                            rushEventFireBase.getLongitude(),
                            rushEventFireBase.isCampus()
                    );

                    response.socialRushEvents.add(rushEvent);
                    index++;
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
