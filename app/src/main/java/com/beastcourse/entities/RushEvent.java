package com.beastcourse.entities;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Andrey on 07.12.2016.
 */

@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
@Getter
public class RushEvent implements Parcelable {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private String eventDescription;
    private double eventLatitude;
    private double eventLongtitude;
    private boolean isOnCampus;



    protected RushEvent(Parcel in) {
        eventId = in.readInt();
        eventName = in.readString();
        eventDate = in.readString();
        eventTime = in.readString();
        eventLocation = in.readString();
        eventDescription = in.readString();
        eventLatitude = in.readDouble();
        eventLongtitude = in.readDouble();
        isOnCampus = in.readByte() != 0;
    }

    public static final Creator<RushEvent> CREATOR = new Creator<RushEvent>() {
        @Override
        public RushEvent createFromParcel(Parcel in) {
            return new RushEvent(in);
        }

        @Override
        public RushEvent[] newArray(int size) {
            return new RushEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(eventId);
        parcel.writeString(eventName);
        parcel.writeString(eventDate);
        parcel.writeString(eventTime);
        parcel.writeString(eventLocation);
        parcel.writeString(eventDescription);
        parcel.writeDouble(eventLatitude);
        parcel.writeDouble(eventLongtitude);
        parcel.writeByte((byte) (isOnCampus ? 1 : 0));
    }
}
