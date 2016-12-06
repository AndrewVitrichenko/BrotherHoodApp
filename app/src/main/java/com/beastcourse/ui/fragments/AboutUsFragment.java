package com.beastcourse.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.beastcourse.services.EventCardService;
import com.beastcourse.ui.activities.BaseActivity;
import com.beastcourse.ui.activities.PhotoPagerActivity;
import com.beastcourse.ui.views.about_us_views.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Andrey on 29.09.2016.
 */

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> brotherHoodCards;
    private ArrayList<EventCard> socialCards;

    @BindView(R.id.fragment_about_us_recyclerView)
    RecyclerView recyclerView;

    private AboutUsAdapter adapter;

    public static AboutUsFragment newInstance(){
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);
        ButterKnife.bind(this,rootView);
        adapter = new AboutUsAdapter((BaseActivity)getActivity(),this);
        serviceCards = adapter.getCommunityServiceEventCards();
        brotherHoodCards = adapter.getBrotherHoodEventCards();
        socialCards = adapter.getSocialEventCards();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setUpAdapter();
        bus.post(new EventCardService.SearchCommunityServiceCardsRequest("Hello"));
        bus.post(new EventCardService.SearchBrotherHoodRequest("Hello"));
        bus.post(new EventCardService.SearchSocialCardRequest("Hello"));
        System.out.println("Hello!");
        return rootView;
    }

    private void setUpAdapter(){
        if (isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onEventCardClicked(EventCard eventCard) {
        if (!eventCard.isVideo()){
            Intent intent = new Intent(PhotoPagerActivity.newInstance(getActivity(),eventCard));
            startActivity(intent);
        }
    }

    @Subscribe
    public void getCommunityCards(EventCardService.SearchCommunityServiceCardsResponse response){
        serviceCards.clear();
        serviceCards.addAll(response.communityServiceCards);
    }
    @Subscribe
    public void getBrotherHoodCards(EventCardService.SearchBrotherHoodResponse response){
        brotherHoodCards.clear();
        brotherHoodCards.addAll(response.brotherHoodCards);
    }
    @Subscribe
    public void getSocialCards(EventCardService.SearchSocialCardResponse response){
        socialCards.clear();
        socialCards.addAll(response.socialCards);
    }
}
