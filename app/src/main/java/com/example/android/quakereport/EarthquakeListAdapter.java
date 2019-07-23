package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeListAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeListAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        Earthquake earthquake = getItem(position);

        if(earthquake !=null){
            magnitudeTextView.setText(earthquake.getMagnitude());
            locationTextView.setText(earthquake.getLocation());
            Date date = new Date(earthquake.getTimeInMilliseconds());
            String formattedDate = formatDate(date);
            dateTextView.setText(formattedDate);
            String formattedTime = formateTime(date);
            timeTextView.setText(formattedTime);
        }

        return listItemView;
    }

    private String formateTime(Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }
}
