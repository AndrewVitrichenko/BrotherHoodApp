package com.beastcourse.live;

import com.beastcourse.entities.EventPicture;
import com.beastcourse.entities.firebaseEntities.EventPictureFireBase;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventPhotoService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LivePictureService extends BaseLiveService {


    public LivePictureService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getCommunnityPhotos(EventPhotoService.SearchCommunityPhotoRequest request) {
        final EventPhotoService.SearchCommunityPhotoResponse response = new EventPhotoService.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                EventPictureFireBase eventPictureFireBase;
                EventPicture eventPicture;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);

                    eventPicture = new EventPicture(
                            eventPictureFireBase.getUrl()
                    );

                    response.communityPhotos.add(eventPicture);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Subscribe
    public void getBrotherHoodPhotos(EventPhotoService.SearchBrotherHoodPhotoRequest request) {
        final EventPhotoService.SearchBrotherHoodResponse response = new EventPhotoService.SearchBrotherHoodResponse();
        response.brotherHoodPhotos = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                EventPictureFireBase eventPictureFireBase;
                EventPicture eventPicture;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);

                    eventPicture = new EventPicture(
                            eventPictureFireBase.getUrl()
                    );

                    response.brotherHoodPhotos.add(eventPicture);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotosRequest request) {
        final EventPhotoService.SearchSocialPhotosResponse response = new EventPhotoService.SearchSocialPhotosResponse();
        response.socialPhotos = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                EventPictureFireBase eventPictureFireBase;
                EventPicture eventPicture;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    eventPictureFireBase = dataSnapshot1.getValue(EventPictureFireBase.class);

                    eventPicture = new EventPicture(
                            eventPictureFireBase.getUrl()
                    );

                    response.socialPhotos.add(eventPicture);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
