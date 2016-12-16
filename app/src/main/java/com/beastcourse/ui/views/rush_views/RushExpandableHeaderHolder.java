package com.beastcourse.ui.views.rush_views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beastcourse.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_expandable_header_buttonToogle)
    ImageView buttonToggle;

    @BindView(R.id.list_expandable_header_layout)
    View background;

    @BindView(R.id.list_expandable_header_name)
    TextView headerName;

    public Item refferalItem;


    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


}
