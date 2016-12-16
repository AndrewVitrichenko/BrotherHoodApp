package com.beastcourse.entities.firebaseEntities;

import lombok.Getter;

/**
 * Created by Andrey on 16.12.2016.
 */

@Getter
public class EventCardFireBase {

    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    private boolean isVideo;
    private String youtubeEnding;


    private EventCardFireBase(){

    }
}
