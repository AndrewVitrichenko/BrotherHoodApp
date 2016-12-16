package com.beastcourse.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.beastcourse.R;
import com.beastcourse.entities.Brother;
import com.beastcourse.ui.fragments.AboutUsFragment;
import com.beastcourse.ui.fragments.MeetABroFragment;

/**
 * Created by Andrey on 12.12.2016.
 */

public class PracticeActivity extends BaseActivity {

    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_practice_fragment_container);

        if (fragment == null) {
            fragment = AboutUsFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_practice_fragment_container, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context context, Brother brother){
        Intent intent = new Intent(context,PracticeActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
