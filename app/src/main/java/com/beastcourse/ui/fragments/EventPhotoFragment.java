package com.beastcourse.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.beastcourse.R;
import com.beastcourse.entities.EventPicture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;



public class EventPhotoFragment extends BaseFragment {

    @BindView(R.id.fragment_event_picture_image)
    ImageView eventImage;
    @BindView(R.id.fragment_event_picture_progressBar)
    ProgressBar progressBar;

    public static final String EVENT_PHOTO_INFO = "EVENT_PHOTO_INFO";
    private String photoUrl;

    public static EventPhotoFragment newInstance(EventPicture eventPicture){
        Bundle arguments = new Bundle();
        arguments.putString(EVENT_PHOTO_INFO,eventPicture.getUrl());
        EventPhotoFragment eventPhotoFragment = new EventPhotoFragment();
        eventPhotoFragment.setArguments(arguments);
        return eventPhotoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EVENT_PHOTO_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_picture,container,false);
        ButterKnife.bind(this,rootView);
        loadPhoto();
        return rootView;
    }


    public void loadPhoto(){
        Glide.with(getActivity()).load(photoUrl).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                if(e instanceof UnknownHostException)
                    progressBar.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model,
                                           Target<GlideDrawable> target,
                                           boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).fitCenter().centerCrop().into(eventImage);
    }
}
