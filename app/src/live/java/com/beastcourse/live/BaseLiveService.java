package com.beastcourse.live;

import com.beastcourse.infrastructure.BeastApplication;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;


public class BaseLiveService {
    protected final Bus bus;
    protected final BeastApplication application;
    protected final DatabaseReference databaseReference;
    public static final String FIRE_BASE_REFERENCE = "https://brotherhood-151719.firebaseio.com/";

    public BaseLiveService(BeastApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}
