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
    private static final String LOCATION_SEPARATOR = "of";

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
        Earthquake earthquake = getItem(position);


        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);

        if(earthquake !=null){
            magnitudeTextView.setText(earthquake.getMagnitude());
            String originalLocation = earthquake.getLocation();
            String primaryLocation;
            String locationOffset;
            if (originalLocation.contains(LOCATION_SEPARATOR)) {
                String[] parts = originalLocation.split(LOCATION_SEPARATOR);
                locationOffset = parts[0] + LOCATION_SEPARATOR;
                primaryLocation = parts[1];
            } else {
                locationOffset = getContext().getString(R.string.near_the);
                primaryLocation = originalLocation;
            }
            locationOffsetTextView.setText(locationOffset);
            locationTextView.setText(primaryLocation);
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
