package com.beastcourse.inmemory;

import com.beastcourse.entities.Brother;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.BrotherService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Andrey on 02.10.2016.
 */

public class InMemoryBrotherService extends BaseInMemory {

    public InMemoryBrotherService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getBrothers(BrotherService.SearchBrotherRequest request){
        BrotherService.SearchBrotherResponse response = new BrotherService.SearchBrotherResponse();
        response.brothers = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            response.brothers.add(new Brother(
                    i,
                    "Brother " + i, "joined for this reason",
                    "http://www.gravatar.com/avatar/" + i + "?id=identicon",
                    "Mechanical Engineering",
                    "Spring 2013",
                    "Love to code"
            ));
        }
        bus.post(response);
    }
}
