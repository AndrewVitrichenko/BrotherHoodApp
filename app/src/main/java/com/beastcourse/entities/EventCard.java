package com.beastcourse.entities;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Andrey on 09.11.2016.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EventCard {

    @Getter private int eventId;
    @Getter private String eventName;
    @Getter private String eventDescription;
    @Getter private String eventImage;
    @Getter private boolean isVideo;
    @Getter private String youtubeEnding;


}
