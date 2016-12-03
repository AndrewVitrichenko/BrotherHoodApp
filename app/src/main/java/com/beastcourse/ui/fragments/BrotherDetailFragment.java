package com.beastcourse.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.beastcourse.R;
import com.beastcourse.R2;
import com.beastcourse.entities.Brother;
import com.beastcourse.services.BrotherService;
import com.beastcourse.ui.activities.BaseActivity;
import com.beastcourse.ui.views.meet_a_bro_views.MeetABroAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 07.11.2016.
 */

public class BrotherDetailFragment extends BaseFragment {

    @BindView(R2.id.fragment_brother_details_ProgressBar)
    ProgressBar progressBar;
    @BindView(R2.id.fragment_brother_detail_brotherCrossed)
    TextView brotherCrossed;
    @BindView(R2.id.fragment_brother_detail_brotherFunFact)
    TextView brotherFunFact;
    @BindView(R2.id.fragment_brother_detail_brotherMajor)
    TextView brotherMajor;
    @BindView(R2.id.fragment_brother_detail_brotherName)
    TextView brotherName;
    @BindView(R2.id.fragment_brother_detail_whyJoined)
    TextView brotherWhyJoined;
    @BindView(R2.id.fragment_brother_details_picture)
    ImageView brotherPicture;

    private Brother brother;
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_brothers_details, container, false);
        ButterKnife.bind(this,rootView);
        loadBrotherPicture();
        brotherName.setText(brother.getBrotherName());
        brotherCrossed.setText(getString(R.string.crossed_intro,brother.getBrotherCrossSemester()));
        brotherFunFact.setText(getString(R.string.fun_fact_intro,brother.getBrotherFunFact()));
        brotherMajor.setText(getString(R.string.major_intro,brother.getBrotherMajor()));
        brotherWhyJoined.setText(brother.getBrotherWhyJoin());

        return rootView;
    }

    public static BrotherDetailFragment newInstance(Brother brother){
        Bundle arguments = new Bundle();
        arguments.putParcelable(BROTHER_EXTRA_INFO,brother);
        BrotherDetailFragment brotherDetailFragment = new BrotherDetailFragment();
        brotherDetailFragment.setArguments(arguments);
        return brotherDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);

    }

    public void loadBrotherPicture(){
        Glide.with(getActivity()).load(brother.getBrotherPicture()).listener(new RequestListener<String, GlideDrawable>() {
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
        }).fitCenter().centerCrop().into(brotherPicture);
    }
}
