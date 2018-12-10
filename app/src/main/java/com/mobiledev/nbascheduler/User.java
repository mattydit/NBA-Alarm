package com.mobiledev.nbascheduler;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User
{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "fav_team")
    private String fav_team;

    public User(int id, @NonNull String username, String fav_team)
    {
        this.id = id;
        this.username = username;
        this.fav_team = fav_team;
    }

    public String getFav_team() {
        return fav_team;
    }

    public void setFav_team(String fav_team) {
        this.fav_team = fav_team;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
