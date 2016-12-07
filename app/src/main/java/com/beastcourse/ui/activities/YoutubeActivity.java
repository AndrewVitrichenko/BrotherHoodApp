package com.beastcourse.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.beastcourse.infrastructure.BeastApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 07.12.2016.
 */

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    @BindView(R.id.activity_youtube_player_view)
    YouTubePlayerView youTubePlayerView;

    private String videoUrl;
    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";

    public static Intent newInstance(Context context, EventCard eventCard) {
        Intent intent = new Intent(context, YoutubeActivity.class);
        intent.putExtra(EXTRA_VIDEO_INFO, eventCard.getYoutubeEnding());
        return intent;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube);
        ButterKnife.bind(this);
        videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        youTubePlayerView.initialize(BeastApplication.YOUTUBE_API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoUrl);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
