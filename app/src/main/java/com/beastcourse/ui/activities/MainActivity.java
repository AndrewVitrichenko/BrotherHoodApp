package com.beastcourse.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.beastcourse.R;
import com.beastcourse.R2;
import com.beastcourse.ui.views.MainActivityViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.activity_main_viewPager)
    ViewPager mainViewPager;
    @BindView(R2.id.activity_main_tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityViewPager adapter = new MainActivityViewPager(getSupportFragmentManager());
        mainViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mainViewPager);
    }
}
