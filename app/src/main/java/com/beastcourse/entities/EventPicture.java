package com.beastcourse.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Andrey on 03.12.2016.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
public class EventPicture {

    @Getter
    private String url;
}
