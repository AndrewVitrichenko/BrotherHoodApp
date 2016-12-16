package com.beastcourse.ui.views.rush_views;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.beastcourse.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RushFooterHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.footer_rush_fragment_facebook)
    ImageView facebookImage;
    @BindView(R.id.footer_rush_fragment_instagram)
    ImageView instagramImage;
    @BindView(R.id.footer_rush_fragment_snapchat)
    ImageView snapchatImage;
    @BindView(R.id.footer_rush_fragment_twitter)
    ImageView twitterImage;

    public RushFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.footer_rush_fragment_twitter)
    public void toTwitter(View view) {
        Intent intent;
        try {
            view.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=27673684"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (PackageManager.NameNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/djkhaled"));
        }
        view.getContext().startActivity(intent);

    }

    @OnClick(R.id.footer_rush_fragment_facebook)
    public void toFacebook(View view){
        Intent intent;
        try {
            view.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/605083229565089"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (PackageManager.NameNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/officialdjkhaled"));
        }
        view.getContext().startActivity(intent);
    }

    @OnClick(R.id.footer_rush_fragment_snapchat)
    public void toSnapchat(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://snapchat.com/add/" + "djkhaled"));
        view.getContext().startActivity(intent);

    }

    @OnClick(R.id.footer_rush_fragment_instagram)
    public void toInstagram(View view){
        Intent intent;
        try {
            view.getContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/djkhaled"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (PackageManager.NameNotFoundException e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/djkhaled"));
        }
        view.getContext().startActivity(intent);
    }

    public void populateImages(){
        facebookImage.setImageResource(R.drawable.facebook);
        twitterImage.setImageResource(R.drawable.twitter);
        snapchatImage.setImageResource(R.drawable.snapchat);
        instagramImage.setImageResource(R.drawable.instagram);
    }
}
