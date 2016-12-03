package com.beastcourse.ui.views.about_us_views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.beastcourse.R;
import com.beastcourse.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 10.11.2016.
 */

public class AboutUsListHeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R2.id.simple_header_textView)
    TextView headerText;

    public AboutUsListHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(String header){
        headerText.setText(header);
    }
}
