package com.beastcourse.inmemory;

import com.beastcourse.infrastructure.BeastApplication;

/**
 * Created by Andrey on 02.10.2016.
 */

public class Module {

    public static void register(BeastApplication application){
        new InMemoryBrotherService(application);
    }

}
