package com.beastcourse.inmemory;

import com.beastcourse.entities.EventCard;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Andrey on 01.12.2016.
 */

public class InMemoryCardsService extends BaseInMemory {

    public InMemoryCardsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunityServiceCardsRequest request) {
        EventCardService.SearchCommunityServiceCardsResponse response = new EventCardService.SearchCommunityServiceCardsResponse();
        response.communityServiceCards = new ArrayList<>();

        response.communityServiceCards.add(new EventCard(
                1,
                "Community Event 1",
                "Community Event 1`s description",
                "http://www.gravatar.com/avatar/" + 1 + "?id=identicon",
                false,
                "null"
        ));

        response.communityServiceCards.add(new EventCard(
                2,
                "Community Event 2",
                "Community Event 2`s description",
                "http://www.gravatar.com/avatar/" + 2 + "?id=identicon",
                true,
                "-3bMERyIUWo"
        ));

        bus.post(response);
    }

    @Subscribe
    public void searchBrotherHoodCards(EventCardService.SearchBrotherHoodRequest request) {
        EventCardService.SearchBrotherHoodResponse response = new EventCardService.SearchBrotherHoodResponse();
        response.brotherHoodCards = new ArrayList<>();

        response.brotherHoodCards.add(new EventCard(
                3,
                "BrotherHood Event 1",
                "BrotherHood Event 1`s description",
                "http://www.gravatar.com/avatar/" + 1 + "?id=identicon",
                false,
                "null"
        ));

        response.brotherHoodCards.add(new EventCard(
                4,
                "BrotherHood Event 2",
                "BrotherHood Event 2`s description",
                "http://www.gravatar.com/avatar/" + 2 + "?id=identicon",
                true,
                "h5EofwRzit0"
        ));

        bus.post(response);
    }

    @Subscribe
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request) {
        EventCardService.SearchSocialCardResponse response = new EventCardService.SearchSocialCardResponse();
        response.socialCards = new ArrayList<>();

        response.socialCards.add(new EventCard(
                5,
                "Social Event 1",
                "Social Event 1`s description",
                "http://www.gravatar.com/avatar/" + 1 + "?id=identicon",
                false,
                "null"
        ));

        response.socialCards.add(new EventCard(
                6,
                "Social Event 2",
                "Social Event 2`s description",
                "http://www.gravatar.com/avatar/" + 2 + "?id=identicon",
                true,
                "Z_Sf0gi-mGI"
        ));

        bus.post(response);
    }
}
