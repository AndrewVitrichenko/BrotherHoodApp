package com.beastcourse.services;

import com.beastcourse.entities.EventCard;

import java.util.List;


public class EventCardService {

    public static class SearchCommunityServiceCardsRequest{
        public String fireBaseUrl;

        public SearchCommunityServiceCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityServiceCardsResponse{
        public List<EventCard> communityServiceCards;
    }

    public static class SearchBrotherHoodRequest{
        public String fireBaseUrl;

        public SearchBrotherHoodRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodResponse{
        public List<EventCard> brotherHoodCards;
    }

    public static class SearchSocialCardRequest{
        public String fireBaseUrl;

        public SearchSocialCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialCardResponse{
        public List<EventCard> socialCards;
    }
}
