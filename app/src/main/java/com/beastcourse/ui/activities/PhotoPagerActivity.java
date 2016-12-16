package com.beastcourse.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.beastcourse.entities.EventPicture;
import com.beastcourse.infrastructure.BeastApplication;
import com.beastcourse.services.EventPhotoService;
import com.beastcourse.ui.fragments.EventPhotoFragment;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhotoPagerActivity extends BaseActivity {

    @BindView(R.id.activity_photo_pager_viewPager)
    ViewPager viewPager;

    private ArrayList<EventPicture> mEventPhotos;
    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);
        ButterKnife.bind(this);
        mEventPhotos = new ArrayList<>();
        int cardId = getIntent().getIntExtra(EXTRA_CARD_INFO,0);

        switch (cardId){
            case 1:
                bus.post(new EventPhotoService.SearchCommunityPhotoRequest(BeastApplication.FIRE_BASE_EVENT_PHOTOS_COMMUNITY_REFERENCE));
                break;
            case 3:
                bus.post(new EventPhotoService.SearchBrotherHoodPhotoRequest(BeastApplication.FIRE_BASE_EVENT_PHOTOS_BROTHERHOOD_REFERENCE));
                break;
            case 5:
                bus.post(new EventPhotoService.SearchSocialPhotosRequest(BeastApplication.FIRE_BASE_EVENT_PHOTOS_SOCIAL_REFERENCE));
                break;
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture eventPicture = mEventPhotos.get(position);
                return EventPhotoFragment.newInstance(eventPicture);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });
    }

    public static Intent newInstance(Context context, EventCard eventCard) {
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return intent;
    }

    @Subscribe
    public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotoResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.communityPhotos);
        viewPager.getAdapter().notifyDataSetChanged();
    }
    @Subscribe
    public void getBrotherHoodPhotos(EventPhotoService.SearchBrotherHoodResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.brotherHoodPhotos);
        viewPager.getAdapter().notifyDataSetChanged();
    }
    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotosResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.socialPhotos);
        viewPager.getAdapter().notifyDataSetChanged();
    }
}
