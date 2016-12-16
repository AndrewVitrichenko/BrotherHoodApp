package com.beastcourse.ui.views.rush_views;

import com.beastcourse.entities.RushEvent;

import java.util.List;


public class Item {

    public int type;
    public String header;
    public RushEvent rushEvent;
    public List<Item> invisibleChildren;

    public Item(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }

    public Item(int type, String header) {
        this.type = type;
        this.header = header;
    }
}
