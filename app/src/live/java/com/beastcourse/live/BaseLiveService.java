package com.beastcourse.live;

import com.beastcourse.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by Andrey on 12.12.2016.
 */

public class BaseLiveService {
    protected final Bus bus;
    protected final BeastApplication application;

    public BaseLiveService(BeastApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }
}
