package com.beastcourse.entities.firebaseEntities;

import lombok.Getter;

@Getter
public class EventCardFireBase {

    private String title;
    private String description;
    private String picture;
    private boolean video;
    private String url;


    private EventCardFireBase(){

    }
}
