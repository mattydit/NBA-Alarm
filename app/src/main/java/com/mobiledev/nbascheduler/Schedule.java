package com.mobiledev.nbascheduler;

import android.graphics.drawable.Drawable;

public class Schedule
{
    private String gameID;
    private String g_date;
    private String home_team;
    private String visitor_team;
    private String UTCtime;
    private Drawable logoAway;
    private Drawable logoHome;

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

    public Drawable getLogoAway() {
        return logoAway;
    }

    public void setLogoAway(Drawable logoAway) {
        this.logoAway = logoAway;
    }

    public Drawable getLogoHome() {
        return logoHome;
    }

    public void setLogoHome(Drawable logoHome) {
        this.logoHome = logoHome;
    }
}
