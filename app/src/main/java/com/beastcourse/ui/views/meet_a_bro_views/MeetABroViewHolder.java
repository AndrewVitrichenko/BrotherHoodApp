package com.beastcourse.ui.views.meet_a_bro_views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.beastcourse.R;
import com.beastcourse.entities.Brother;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MeetABroViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_meet_a_bro_ImageView)
    ImageView brotherPicture;
    @BindView(R.id.list_meet_a_bro_ProgressBar)
    ProgressBar brotherProgressBar;


    public MeetABroViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, Brother brother){
        itemView.setTag(brother);
        Glide.with(context).load(brother.getBrotherPicture()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                if(e instanceof UnknownHostException)
                    brotherProgressBar.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model,
                                           Target<GlideDrawable> target,
                                           boolean isFromMemoryCache, boolean isFirstResource) {
                brotherProgressBar.setVisibility(View.GONE);
                return false;
            }
        }).fitCenter().centerCrop().into(brotherPicture);
    }

}
