package com.beastcourse.services;

import com.beastcourse.entities.EventPicture;

import java.util.List;

/**
 * Created by Andrey on 03.12.2016.
 */

public class EventPhotoService {

    public static class SearchCommunityPhotoRequest{
        public String fireBaseUrl;

        public SearchCommunityPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityPhotoResponse {
        public List<EventPicture> communityPhotos;
    }

    public static class SearchBrotherHoodPhotoRequest{
        public String fireBaseUrl;

        public SearchBrotherHoodPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodResponse{
        public List<EventPicture> brotherHoodPhotos;
    }

    public static class SearchSocialPhotosRequest{
        public String fireBaseUrl;

        public SearchSocialPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialPhotosResponse{
        public List<EventPicture> socialPhotos;
    }
}
