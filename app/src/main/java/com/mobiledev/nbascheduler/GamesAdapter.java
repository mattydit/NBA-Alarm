package com.mobiledev.nbascheduler;

import android.content.Context;
import androidx.annotation.NonNull;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GamesAdapter extends ArrayAdapter<Schedule>
{
    private List<Schedule> scheduleList;

    private Context context;

    public GamesAdapter(List<Schedule> scheduleList, Context context)
    {
        super(context, R.layout.list_items, scheduleList);
        this.scheduleList = scheduleList;
        this.context = context;
    }

    //Method to return the list item.
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_items, null, true);
        //text view components
        TextView textDate = listViewItem.findViewById(R.id.DateView);
        TextView textTime = listViewItem.findViewById(R.id.TimeView);
        TextView textAway = listViewItem.findViewById(R.id.TeamAway);
        TextView textHome = listViewItem.findViewById(R.id.TeamHome);
        ImageView logoAway = listViewItem.findViewById(R.id.LogoAway);
        ImageView logoHome = listViewItem.findViewById(R.id.LogoHome);

        //Get JSON data for the position
        Schedule items = scheduleList.get(position);

        //Set json values to the text views
        textDate.setText(items.getG_date());
        textTime.setText(items.getUTCtime());
        textAway.setText(items.getVisitor_team());
        textHome.setText(items.getHome_team());
        logoAway.set
        logoHome.setImageDrawable((items.getLogoHome()));

        return listViewItem;
    }
}
