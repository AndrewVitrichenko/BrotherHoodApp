package com.beastcourse.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
public class EventPicture {

    @Getter
    private String url;
}
