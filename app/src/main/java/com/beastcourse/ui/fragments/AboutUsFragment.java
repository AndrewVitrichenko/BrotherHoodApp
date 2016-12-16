package com.beastcourse.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventCardService;
import com.beastcourse.ui.activities.BaseActivity;
import com.beastcourse.ui.activities.PhotoPagerActivity;
import com.beastcourse.ui.activities.YoutubeActivity;
import com.beastcourse.ui.views.about_us_views.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> brotherHoodCards;
    private ArrayList<EventCard> socialCards;

    @BindView(R.id.fragment_about_Us_recyclerView)
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
        bus.post(new EventCardService.SearchCommunityServiceCardsRequest(BeastApplication.FIRE_BASE_EVENT_CARDS_COMMUNITY_REFERENCE));
        bus.post(new EventCardService.SearchBrotherHoodRequest(BeastApplication.FIRE_BASE_EVENT_CARDS_BROTHERHOOD_REFERENCE));
        bus.post(new EventCardService.SearchSocialCardRequest(BeastApplication.FIRE_BASE_EVENT_CARDS_SOCIAL_REFERENCE));
        return rootView;
    }

    private void setUpAdapter(){
        if (isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onEventCardClicked(EventCard eventCard) {
        Intent intent;
        if (!eventCard.isVideo()){
            intent = PhotoPagerActivity.newInstance(getActivity(),eventCard);
        } else {
            intent = YoutubeActivity.newInstance(getActivity(),eventCard);
        }
        startActivity(intent);
    }

    @Subscribe
    public void getCommunityCards(EventCardService.SearchCommunityServiceCardsResponse response){
        int oldSize = serviceCards.size();
        if (oldSize == 0) {
            serviceCards.clear();
            adapter.notifyItemRangeRemoved(0,oldSize);
            serviceCards.addAll(response.communityServiceCards);
            adapter.notifyItemRangeInserted(0,serviceCards.size());
        }
    }
    @Subscribe
    public void getBrotherHoodCards(EventCardService.SearchBrotherHoodResponse response){
        int oldSize = brotherHoodCards.size();
        if (oldSize == 0) {
            brotherHoodCards.clear();
            adapter.notifyItemRangeRemoved(0,oldSize);
            brotherHoodCards.addAll(response.brotherHoodCards);
            adapter.notifyItemRangeInserted(0,brotherHoodCards.size());
        }
    }
    @Subscribe
    public void getSocialCards(EventCardService.SearchSocialCardResponse response){
        int oldSize = socialCards.size();
        if (oldSize == 0) {
            socialCards.clear();
            adapter.notifyItemRangeRemoved(0,oldSize);
            socialCards.addAll(response.socialCards);
            adapter.notifyItemRangeInserted(0,socialCards.size());
        }
    }
}
