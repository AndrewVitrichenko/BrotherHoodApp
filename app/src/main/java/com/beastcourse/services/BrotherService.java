package com.beastcourse.services;

import com.beastcourse.entities.Brother;

import java.util.List;

public class BrotherService {

    public BrotherService(){

    }
    public static class SearchBrotherRequest{
        public String fireBaseUrl;

        public SearchBrotherRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherResponse{
        public List<Brother> brothers;
    }
}
