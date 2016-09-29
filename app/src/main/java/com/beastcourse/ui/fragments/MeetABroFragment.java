package com.beastcourse.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;


/**
 * Created by Andrey on 29.09.2016.
 */

public class MeetABroFragment extends Fragment {

    public static MeetABroFragment newInstance(){
        return new MeetABroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro,container,false);
        return rootView;
    }
}
