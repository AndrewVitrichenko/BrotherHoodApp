package com.beastcourse.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.RushEvent;
import com.beastcourse.services.RushEventService;
import com.beastcourse.ui.activities.BaseActivity;
import com.beastcourse.ui.activities.CampusMapActivity;
import com.beastcourse.ui.activities.MapsActivity;
import com.beastcourse.ui.views.rush_views.Item;
import com.beastcourse.ui.views.rush_views.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {

    @BindView(R.id.fragment_rush_recyclerView)
    RecyclerView recyclerView;

    private RushEventAdapter adapter;
    private ArrayList<RushEvent> communityEvents;
    private ArrayList<RushEvent> socialEvents;

    private Item socialItem;
    private Item communityItem;


    public static RushFragment newInstance(){
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush,container,false);
        ButterKnife.bind(this,rootView);

        adapter = new RushEventAdapter((BaseActivity) getActivity(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        communityEvents = new ArrayList<>();
        socialEvents = new ArrayList<>();
        List<Item> data = adapter.getData();

        socialItem = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Social Events");
        socialItem.invisibleChildren = new ArrayList<>();
        communityItem = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Community Events");
        communityItem.invisibleChildren = new ArrayList<>();

        bus.post(new RushEventService.SearchRushEventsCommunityRequest("Hello!"));
        bus.post(new RushEventService.SearchRushEventsSocialRequest("Hello!"));
        setUpAdapter();

        data.add(communityItem);
        data.add(socialItem);

        return rootView;
    }

    public void setUpAdapter(){
        if (isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onRushEventClicked(RushEvent rushEvent) {
        Intent intent;
        if (!rushEvent.isOnCampus()){
            intent = MapsActivity.newIntent(getActivity(),rushEvent);
        } else {
            intent = CampusMapActivity.newIntent(getActivity(),rushEvent);
        }
        startActivity(intent);
    }

    @Subscribe
    public void getCommunityEvents(RushEventService.SearchRushEventsCommunityResponse response){
        communityEvents.clear();
        communityEvents.addAll(response.communityRushEvents);
        for (RushEvent rushEvent : communityEvents){
            communityItem.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvent));
        }
    }

    @Subscribe
    public void getSocialEvents(RushEventService.SearchRushEventsSocialResponse response){
        socialEvents.clear();
        socialEvents.addAll(response.socialRushEvents);
        for (RushEvent rushEvent : socialEvents){
            socialItem.invisibleChildren.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvent));
        }
    }
}
