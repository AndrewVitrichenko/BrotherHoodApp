package com.beastcourse.ui.views.about_us_views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BrotherHoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;
    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescription;
    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;
    @BindView(R.id.list_event_card_imageView)
    ImageView eventImage;
    @BindView(R.id.list_event_card_progressBar)
    ProgressBar progressBar;

    public BrotherHoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, EventCard eventCard){
        itemView.setTag(eventCard);
        eventName.setText(eventCard.getEventName());
        eventDescription.setText(eventCard.getEventDescription());

        if (!eventCard.isVideo()){
            eventType.setImageResource(R.mipmap.camera);
        } else {
            eventType.setImageResource(R.mipmap.video);
        }
        loadEventImage(context,eventCard);

    }


    public void loadEventImage(Context context,EventCard eventCard){
        Glide.with(context).load(eventCard.getEventImage()).listener(new RequestListener<String, GlideDrawable>() {
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
