package com.beastcourse.entities;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Andrey on 09.11.2016.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
@Getter
public class EventCard {

    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    private boolean isVideo;
    private String youtubeEnding;


}
