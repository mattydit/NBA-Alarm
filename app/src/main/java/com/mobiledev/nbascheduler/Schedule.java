package com.mobiledev.nbascheduler;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Schedule
{
    private String gameID;
    private String g_date;
    private String home_team;
    private String visitor_team;
    private String UTCtime;
    private ImageView logoAway;
    private ImageView logoHome;

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getG_date() {
        return g_date;
    }

    public void setG_date(String g_date) {
        this.g_date = g_date;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getVisitor_team() {
        return visitor_team;
    }

    public void setVisitor_team(String visitor_team) {
        this.visitor_team = visitor_team;
    }

    public String getUTCtime() {
        return UTCtime;
    }

    public void setUTCtime(String UTCtime) {
        this.UTCtime = UTCtime;
    }

    public ImageView getLogoAway() {
        return logoAway;
    }

    public void setLogoAway(ImageView logoAway) {
        this.logoAway = logoAway;
    }

    public ImageView getLogoHome() {
        return logoHome;
    }

    public void setLogoHome(ImageView logoHome) {
        this.logoHome = logoHome;
    }
}
