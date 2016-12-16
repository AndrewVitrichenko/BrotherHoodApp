package com.beastcourse.ui.views.about_us_views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beastcourse.R;
import com.beastcourse.entities.EventCard;
import com.beastcourse.ui.activities.BaseActivity;

import java.util.ArrayList;

import lombok.Getter;


public class AboutUsAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_BROTHERHOOD_LIST = 3;
    private final int VIEW_TYPE_SOCIAL_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    @Getter
    private ArrayList<EventCard> communityServiceEventCards;
    @Getter
    private ArrayList<EventCard> brotherHoodEventCards;
    @Getter
    private ArrayList<EventCard> socialEventCards;
    private LayoutInflater inflater;
    private BaseActivity activity;
    private AboutUsListener listener;

    public AboutUsAdapter(BaseActivity activity, AboutUsListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        communityServiceEventCards = new ArrayList<>();
        brotherHoodEventCards = new ArrayList<>();
        socialEventCards = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_MAIN_HEADER;
        }

        position--;

        if (communityServiceEventCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }

            position--;

            if (position < communityServiceEventCards.size()) {
                return VIEW_TYPE_SERVICE_LIST;
            }

            position -= communityServiceEventCards.size();
        }

        if (brotherHoodEventCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

            if (position < brotherHoodEventCards.size()) {
                return VIEW_TYPE_BROTHERHOOD_LIST;
            }

            position -= brotherHoodEventCards.size();
        }

        if (socialEventCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;


            if (position < socialEventCards.size()) {
                return VIEW_TYPE_SOCIAL_LIST;
            }

            position -= socialEventCards.size();

        }
        throw new IllegalArgumentException();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventCardView = inflater.inflate(R.layout.list_event_card, parent, false);
        View listHeader = inflater.inflate(R.layout.simple_header, parent, false);

        if (viewType == VIEW_TYPE_MAIN_HEADER) {
            return new AboutUsMainHeaderViewHolder(inflater, parent);
        } else if (viewType == VIEW_TYPE_SERVICE_LIST) {
            final CommunityServiceViewHolder communityServiceViewHolder = new CommunityServiceViewHolder(eventCardView);
            communityServiceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) communityServiceViewHolder.itemView.getTag();
                    listener.onEventCardClicked(eventCard);
                }
            });
            return communityServiceViewHolder;
        } else if (viewType == VIEW_TYPE_BROTHERHOOD_LIST) {
            final BrotherHoodViewHolder brotherHoodViewHolder = new BrotherHoodViewHolder(eventCardView);
            brotherHoodViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) brotherHoodViewHolder.itemView.getTag();
                    listener.onEventCardClicked(eventCard);
                }
            });
            return brotherHoodViewHolder;
        } else if (viewType == VIEW_TYPE_SOCIAL_LIST) {
            final SocialViewHolder socialViewHolder = new SocialViewHolder(eventCardView);
            socialViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) socialViewHolder.itemView.getTag();
                    listener.onEventCardClicked(eventCard);
                }
            });
            return socialViewHolder;
        } else if (viewType == VIEW_TYPE_LIST_HEADER) {
            return new AboutUsListHeaderViewHolder(listHeader);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AboutUsMainHeaderViewHolder) {
            AboutUsMainHeaderViewHolder holder1 = (AboutUsMainHeaderViewHolder) holder;
        }

        if (holder instanceof CommunityServiceViewHolder) {
            position--;
            if (communityServiceEventCards.size() > 0) {
                position--;
            }
            EventCard eventCard = communityServiceEventCards.get(position);
            ((CommunityServiceViewHolder) holder).populate(activity, eventCard);
        }

        if (holder instanceof BrotherHoodViewHolder) {
            position--;
            if (brotherHoodEventCards.size() > 0) {
                position--;
                position -= brotherHoodEventCards.size();
            }

            if (brotherHoodEventCards.size() > 0) {
                position--;
            }

            EventCard eventCard = brotherHoodEventCards.get(position);
            ((BrotherHoodViewHolder) holder).populate(activity, eventCard);
        }

        if (holder instanceof SocialViewHolder) {
            position--;
            if (communityServiceEventCards.size() > 0) {
                position--;
                position -= communityServiceEventCards.size();
            }

            if (brotherHoodEventCards.size() > 0) {
                position--;
                position -= brotherHoodEventCards.size();
            }

            if (socialEventCards.size() > 0) {
                position--;
            }

            EventCard eventCard = socialEventCards.get(position);
            ((SocialViewHolder) holder).populate(activity, eventCard);
        }

        if (holder instanceof AboutUsListHeaderViewHolder) {
            AboutUsListHeaderViewHolder aboutUsListHeaderViewHolder = (AboutUsListHeaderViewHolder) holder;
            int servicePosition = 1;
            int brotherHoodPosition = servicePosition + communityServiceEventCards.size() + 1;
            int socialPosition = brotherHoodPosition + brotherHoodEventCards.size() + 1;

            if (position == servicePosition) {
                aboutUsListHeaderViewHolder.populate("Community Service Events");
            }

            if (position == brotherHoodPosition) {
                aboutUsListHeaderViewHolder.populate("Brother Events");
            }

            if (position == socialPosition) {
                aboutUsListHeaderViewHolder.populate("Social Events");
            }
        }

    }

    @Override
    public int getItemCount() {
        int count = 1;

        if (communityServiceEventCards.size() > 0) {
            count += communityServiceEventCards.size() + 1;
        }
        if (brotherHoodEventCards.size() > 0) {
            count += brotherHoodEventCards.size() + 1;
        }
        if (socialEventCards.size() > 0) {
            count += socialEventCards.size() + 1;
        }
        return count;
    }

    public interface AboutUsListener {
        void onEventCardClicked(EventCard eventCard);
    }
}
