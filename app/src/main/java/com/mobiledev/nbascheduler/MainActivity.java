package com.mobiledev.nbascheduler;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;

import android.view.View;
import android.widget.ImageView;

import com.mobiledev.nbascheduler.database.ReminderDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ReminderDatabase reminderDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReminderDatabase database = Room.databaseBuilder(getApplicationContext(),
                ReminderDatabase.class, "reminderDB")
                .allowMainThreadQueries()
                .build();

        AppCompatButton dailybutton = findViewById(R.id.daily);
        AppCompatButton teamSchedbtn = findViewById(R.id.team_schedule);
        AppCompatButton newsbutton = findViewById(R.id.news);
        AppCompatButton remindersbtn = findViewById(R.id.remindersbtn);
        ImageView settingsbtn = findViewById(R.id.settings);

        dailybutton.setOnClickListener(this);
        teamSchedbtn.setOnClickListener(this);
        newsbutton.setOnClickListener(this);
        settingsbtn.setOnClickListener(this);
        remindersbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Context context = getApplicationContext();

        switch (v.getId())
        {
            case R.id.settings:
            {
                Intent settings_intent = new Intent(context, UserSettings.class);
                startActivity(settings_intent);
                break;
            }
            case R.id.daily:
            {
                Intent daily_intent = new Intent(context, Daily.class);
                startActivity(daily_intent);
                break;
            }
            case R.id.remindersbtn:
            {
                Intent reminders_intent = new Intent(context, RemindersActivity.class);
                startActivity(reminders_intent);
                break;
            }
            case R.id.team_schedule:
            {
                Intent team_intent = new Intent(context, TeamActivity.class);
                startActivity(team_intent);
                break;
            }
            case R.id.news:
            {
                Intent news_intent = new Intent(context, NewsActivity.class);
                startActivity(news_intent);
                break;
            }
        }

    }
}
