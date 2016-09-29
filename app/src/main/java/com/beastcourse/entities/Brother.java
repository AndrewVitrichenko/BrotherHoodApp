package com.beastcourse.entities;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;


/**
 * Created by Andrey on 29.09.2016.
 */
public class Brother implements Parcelable {

    @Getter private int brotherId;
    @Getter private String brotherName;
    @Getter private String brotherWhyJoin;
    @Getter private String brotherPicture;
    @Getter private String brotherMajor;
    @Getter private String brotherCrossSemester;
    @Getter private String brotherFunFact;

    public Brother(int brotherId, String brotherName, String brotherPicture, String brotherWhyJoin, String brotherMajor, String brotherCrossSemester, String brotherFunFact) {
        this.brotherId = brotherId;
        this.brotherName = brotherName;
        this.brotherPicture = brotherPicture;
        this.brotherWhyJoin = brotherWhyJoin;
        this.brotherMajor = brotherMajor;
        this.brotherCrossSemester = brotherCrossSemester;
        this.brotherFunFact = brotherFunFact;
    }

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
