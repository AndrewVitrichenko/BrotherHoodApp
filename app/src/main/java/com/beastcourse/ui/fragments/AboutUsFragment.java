package com.beastcourse.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;


/**
 * Created by Andrey on 29.09.2016.
 */

public class AboutUsFragment extends BaseFragment {


    public static AboutUsFragment newInstance(){
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);
        return rootView;
    }
}
