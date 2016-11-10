package com.beastcourse.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.Brother;
import com.beastcourse.services.BrotherService;
import com.beastcourse.ui.activities.BaseActivity;
import com.beastcourse.ui.activities.BrotherPagerActivity;
import com.beastcourse.ui.views.meet_a_bro_views.MeetABroAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


/**
 * Created by Andrey on 29.09.2016.
 */

public class MeetABroFragment extends BaseFragment implements MeetABroAdapter.OnBrotherClickedListener {

    private MeetABroAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Brother> brothers;

    public static MeetABroFragment newInstance() {
        return new MeetABroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro, container, false);
        adapter = new MeetABroAdapter(this, (BaseActivity) getActivity());
        brothers = adapter.getBrothers();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_meet_a_bro_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        bus.post(new BrotherService.SearchBrotherRequest("sdfsdf"));
        return rootView;
    }

    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent = BrotherPagerActivity.newIntent(getActivity(),brother);
        startActivity(intent);
    }

    @Subscribe
    public void getBrothers(BrotherService.SearchBrotherResponse response){
        brothers.clear();
        brothers.addAll(response.brothers);
    }

}
