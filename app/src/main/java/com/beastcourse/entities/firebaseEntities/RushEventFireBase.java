package com.beastcourse.entities.firebaseEntities;

import lombok.Getter;

@Getter
public class RushEventFireBase {

    private String name;
    private String date;
    private String time;
    private String location;
    private double latitude;
    private double longitude;
    private boolean campus;
    private String description;


    private RushEventFireBase(){

    }
}
