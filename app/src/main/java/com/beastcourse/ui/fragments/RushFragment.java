package com.beastcourse.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;

/**
 * Created by Andrey on 29.09.2016.
 */

public class RushFragment extends BaseFragment {

    public static RushFragment newInstance(){
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush,container,false);
        return rootView;
    }
}
