package com.beastcourse.ui.activities;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Andrey on 17.12.2016.
 */

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
