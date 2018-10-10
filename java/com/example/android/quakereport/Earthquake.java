package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    private String mPlaceName;

    private double mMagnitude;

    private long mDateTime;

    private String mUrl;

    public Earthquake(String place, double magnitude, long datetime, String url) {
        mPlaceName = place;
        mMagnitude = magnitude;
        mDateTime = datetime;
        mUrl = url;
    }

    public String getPlaceName() {

        String[] placeSplit = dividePlaceString();

        if (placeSplit.length == 1) {
            return placeSplit[0];
        }

        return placeSplit[1];
    }

    public String getDirection() {

        String[] placeSplit = dividePlaceString();

        if (placeSplit.length == 1) {
            return null;
        }

        return placeSplit[0] + " of";
    }

    public String[] dividePlaceString() {

        return mPlaceName.split("of");
    }

    public String getMagnitude() {

        DecimalFormat formatter = new DecimalFormat("0.0");

        return formatter.format(mMagnitude);
    }

    public String getDate() {

        Date dateObject = new Date(mDateTime);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy h:m a");
        String dateToDisplay = dateFormatter.format(dateObject);

        return dateToDisplay;
    }

    public String getTime() {

        Date dateObject = new Date(mDateTime);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:m a");
        String dateToDisplay = dateFormatter.format(dateObject);

        return dateToDisplay;
    }

    public String getUrl() { return mUrl; }
}
