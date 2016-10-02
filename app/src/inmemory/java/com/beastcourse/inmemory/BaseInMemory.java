package com.beastcourse.inmemory;

import com.beastcourse.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by Andrey on 02.10.2016.
 */

public class BaseInMemory {
    protected final Bus bus;
    protected final BeastApplication application;

    public BaseInMemory(BeastApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }
}
