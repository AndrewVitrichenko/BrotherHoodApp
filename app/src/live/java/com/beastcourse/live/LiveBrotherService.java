package com.beastcourse.live;

import com.beastcourse.entities.Brother;
import com.beastcourse.entities.firebaseEntities.BrotherFireBase;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.BrotherService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Andrey on 12.12.2016.
 */

public class LiveBrotherService extends BaseLiveService {

    public LiveBrotherService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getBrothers(BrotherService.SearchBrotherRequest request) {
        final BrotherService.SearchBrotherResponse response = new BrotherService.SearchBrotherResponse();
        response.brothers = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    BrotherFireBase brotherFireBase = dataSnapshot1.getValue(BrotherFireBase.class);

                    Brother brother = new Brother(
                            index,
                            brotherFireBase.getName(),
                            brotherFireBase.getWhyJoined(),
                            brotherFireBase.getPicture(),
                            brotherFireBase.getMajor(),
                            brotherFireBase.getCross(),
                            brotherFireBase.getFunFact()
                    );

                    response.brothers.add(brother);
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
