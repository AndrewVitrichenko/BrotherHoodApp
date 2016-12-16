package com.beastcourse.live;

import com.beastcourse.entities.EventCard;
import com.beastcourse.entities.firebaseEntities.EventCardFireBase;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventCardService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LiveCardsService extends BaseLiveService {


    public LiveCardsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunityServiceCardsRequest request) {
        final EventCardService.SearchCommunityServiceCardsResponse response = new EventCardService.SearchCommunityServiceCardsResponse();
        response.communityServiceCards = new ArrayList<>();

        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 1;

                EventCardFireBase eventCardFireBase;
                EventCard eventCard;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);

                    eventCard = new EventCard(
                            index,
                            eventCardFireBase.getTitle(),
                            eventCardFireBase.getDescription(),
                            eventCardFireBase.getPicture(),
                            eventCardFireBase.isVideo(),
                            eventCardFireBase.getUrl()

                    );

                    response.communityServiceCards.add(eventCard);
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
    public void searchBrotherHoodCards(EventCardService.SearchBrotherHoodRequest request) {
        final EventCardService.SearchBrotherHoodResponse response = new EventCardService.SearchBrotherHoodResponse();
        response.brotherHoodCards = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 3;
                EventCardFireBase eventCardFireBase;
                EventCard eventCard;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);

                    eventCard = new EventCard(
                            index,
                            eventCardFireBase.getTitle(),
                            eventCardFireBase.getDescription(),
                            eventCardFireBase.getPicture(),
                            eventCardFireBase.isVideo(),
                            eventCardFireBase.getUrl()

                    );

                    response.brotherHoodCards.add(eventCard);
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
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request) {
        final EventCardService.SearchSocialCardResponse response = new EventCardService.SearchSocialCardResponse();
        response.socialCards = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 5;
                EventCardFireBase eventCardFireBase;
                EventCard eventCard;

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventCardFireBase = dataSnapshot1.getValue(EventCardFireBase.class);

                    eventCard = new EventCard(
                            index,
                            eventCardFireBase.getTitle(),
                            eventCardFireBase.getDescription(),
                            eventCardFireBase.getPicture(),
                            eventCardFireBase.isVideo(),
                            eventCardFireBase.getUrl()
                    );

                    response.socialCards.add(eventCard);
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
