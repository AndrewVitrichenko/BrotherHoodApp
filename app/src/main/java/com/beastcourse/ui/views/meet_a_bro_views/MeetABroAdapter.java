package com.beastcourse.ui.views.meet_a_bro_views;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.Brother;

import java.util.ArrayList;

import lombok.Getter;

/**
 * Created by Andrey on 29.09.2016.
 */

public class MeetABroAdapter extends RecyclerView.Adapter<MeetABroViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private AppCompatActivity activity;
    private OnBrotherClickedListener listener;
    @Getter
    private ArrayList<Brother> brothers;

    public MeetABroAdapter(OnBrotherClickedListener listener, AppCompatActivity activity) {
        this.listener = listener;
        this.activity = activity;
        inflater = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    @Override
    public MeetABroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = inflater.inflate(R.layout.list_meet_a_bro, parent, false);
        return new MeetABroViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MeetABroViewHolder holder, int position) {
        holder.populate(activity, brothers.get(position));
    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof Brother) {
            Brother brother = (Brother) view.getTag();
            listener.onBrotherClicked(brother);
        }
    }

    public interface OnBrotherClickedListener {
        void onBrotherClicked(Brother brother);
    }
}
