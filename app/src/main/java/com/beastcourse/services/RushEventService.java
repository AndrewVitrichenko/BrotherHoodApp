package com.beastcourse.services;

import com.beastcourse.entities.RushEvent;

import java.util.List;

public class RushEventService {

    public static class SearchRushEventsCommunityRequest{
        public String firebaseUrl;

        public SearchRushEventsCommunityRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }

    public static class SearchRushEventsCommunityResponse{
        public List<RushEvent> communityRushEvents;
    }

    public static class SearchRushEventsSocialRequest{
        public String firebaseUrl;

        public SearchRushEventsSocialRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }

    public static class SearchRushEventsSocialResponse{
        public List<RushEvent> socialRushEvents;
    }
}
