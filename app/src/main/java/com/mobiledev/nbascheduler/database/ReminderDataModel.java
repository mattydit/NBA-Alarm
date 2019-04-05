package com.mobiledev.nbascheduler.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "reminderDB")
public class ReminderDataModel
{
    @NonNull
    @PrimaryKey
    private String gameID;

    private String date;
    private String time;
    private String visitor;
    private String home_team;

    public ReminderDataModel(@NonNull String gameID, String date, String time, String visitor,
                             String home_team)
    {
        this.gameID = gameID;
        this.date = date;
        this.time = time;
        this.visitor = visitor;
        this.home_team = home_team;
    }

    @NonNull
    public String getGameID() {
        return gameID;
    }

    public void setGameID(@NonNull String gameID) {
        this.gameID = gameID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }
}
