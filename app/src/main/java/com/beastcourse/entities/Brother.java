package com.beastcourse.entities;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Created by Andrey on 29.09.2016.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
@Getter
public class Brother implements Parcelable {

    private int brotherId;
    private String brotherName;
    private String brotherWhyJoin;
    private String brotherPicture;
    private String brotherMajor;
    private String brotherCrossSemester;
    private String brotherFunFact;


    protected Brother(Parcel in) {
        brotherId = in.readInt();
        brotherName = in.readString();
        brotherWhyJoin = in.readString();
        brotherPicture = in.readString();
        brotherMajor = in.readString();
        brotherCrossSemester = in.readString();
        brotherFunFact = in.readString();
    }

    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(brotherId);
        parcel.writeString(brotherName);
        parcel.writeString(brotherWhyJoin);
        parcel.writeString(brotherPicture);
        parcel.writeString(brotherMajor);
        parcel.writeString(brotherCrossSemester);
        parcel.writeString(brotherFunFact);
    }
}
