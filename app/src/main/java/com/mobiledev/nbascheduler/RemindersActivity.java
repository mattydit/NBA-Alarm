package com.mobiledev.nbascheduler;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class RemindersActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ListView listView;
    private List<Schedule> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        //Daily d1 = new Daily();
        listView = findViewById(R.id.reminderlist);
        scheduleList = new ArrayList<>();

        //Log.d("DB: ", reminderDB.daoAccess().getAllreminders().toString());


    }
}
