package com.beastcourse.ui.views.rush_views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.RushEvent;
import com.beastcourse.ui.activities.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


public class RushEventAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_LIST_HEADER = 1;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_HEADER = 2;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_CHILD = 3;
    private final int VIEW_TYPE_LIST_FOOTER = 4;

    @Getter
    private List<Item> data;
    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private RushEventListener listener;

    public RushEventAdapter(BaseActivity activity, RushEventListener listener) {
        this.activity = activity;
        this.listener = listener;
        layoutInflater = activity.getLayoutInflater();
        data = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LIST_HEADER;
        }
        position--;

        if (position<data.size()){
            return data.get(position).type;
        }
        position -= data.size();

        if (position<data.size()){
            return VIEW_TYPE_LIST_FOOTER;
        }
        position--;

        throw new IllegalArgumentException();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = layoutInflater.inflate(R.layout.list_expandable_header,parent,false);
        View rushEventsView = layoutInflater.inflate(R.layout.list_rush_event,parent,false);
        View rushHeaderView = layoutInflater.inflate(R.layout.header_fragment_rush,parent,false);
        View rushFooterView = layoutInflater.inflate(R.layout.footer_rush_fragment,parent,false);

        switch (viewType){
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderHolder(rushHeaderView);

            case VIEW_TYPE_EXPANDABLE_LIST_CHILD:
                final RushEventsHolder holder = new RushEventsHolder(rushEventsView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent rushEvent = (RushEvent) holder.itemView.getTag();
                        listener.onRushEventClicked(rushEvent);
                    }
                });
                return holder;

            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterHolder(rushFooterView);

            case VIEW_TYPE_EXPANDABLE_LIST_HEADER:
                return new RushExpandableHeaderHolder(expandableHeaderView);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RushExpandableHeaderHolder){
            position--;

            final Item item = data.get(position);
            final RushExpandableHeaderHolder itemController = (RushExpandableHeaderHolder) holder;
            itemController.refferalItem = item;
            itemController.headerName.setText(item.header);

            if (item.invisibleChildren == null){
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            } else {
                itemController.buttonToggle.setImageResource(R.mipmap.open);
            }

            itemController.background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item.invisibleChildren == null){
                        item.invisibleChildren = new ArrayList<>();
                        int count = 0;
                        int position = data.indexOf(itemController.refferalItem);

                        while (data.size() > position + 1 && data.get(position + 1).type == VIEW_TYPE_EXPANDABLE_LIST_CHILD){
                            item.invisibleChildren.add(data.remove(position + 1));
                            count++;
                        }
                        notifyItemRangeRemoved(position + 1,count);
                        itemController.buttonToggle.setImageResource(R.mipmap.open);
                    } else {
                        int position = data.indexOf(itemController.refferalItem);
                        int index = position + 1;

                        for (Item item1 : item.invisibleChildren){
                            data.add(index, item1);
                            index++;
                        }

                        notifyItemRangeInserted(position+1,index - position - 1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        item.invisibleChildren = null;
                    }
                }
            });
        }
        else if (holder instanceof RushEventsHolder){
            position--;
            RushEventsHolder holder1 = (RushEventsHolder) holder;
            holder1.populate(data.get(position).rushEvent);
        } else if (holder instanceof RushHeaderHolder){
            RushHeaderHolder rushHeaderHolder = (RushHeaderHolder) holder;
        } else if (holder instanceof RushFooterHolder){
            RushFooterHolder rushFooterHolder = (RushFooterHolder) holder;
            rushFooterHolder.populateImages();
        }
    }

    @Override
    public int getItemCount() {
        int count = 2;

        if (data.size() > 0){
            count += data.size();
        }

        return count;
    }


    public interface RushEventListener{
        void onRushEventClicked(RushEvent rushEvent);
    }
}
