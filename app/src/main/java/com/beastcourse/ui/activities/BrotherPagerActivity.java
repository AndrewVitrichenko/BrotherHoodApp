package com.beastcourse.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.beastcourse.R;
import com.beastcourse.entities.Brother;
import com.beastcourse.services.BrotherService;
import com.beastcourse.ui.fragments.BrotherDetailFragment;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 09.11.2016.
 */

public class BrotherPagerActivity extends BaseActivity {

    @BindView(R.id.activity_brother_pager)
    ViewPager brotherViewPager;


    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    private ArrayList<Brother> brothers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        ButterKnife.bind(this);
        brothers = new ArrayList<>();
        bus.post(new BrotherService.SearchBrotherRequest("Hello!"));
        brotherViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();

        for (int i = 0; i<brothers.size(); i++){
            if (brothers.get(i).getBrotherId() == brotherId){
                brotherViewPager.setCurrentItem(i);
                break;
            }
        }
    }


    @Subscribe
    public void getBrothers(BrotherService.SearchBrotherResponse response){
        brothers.clear();
        brothers.addAll(response.brothers);
    }

    public static Intent newIntent(Context context, Brother brother){
        Intent intent = new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
