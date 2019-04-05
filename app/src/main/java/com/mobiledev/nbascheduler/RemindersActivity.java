package com.mobiledev.nbascheduler;

import androidx.room.Room;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.mobiledev.nbascheduler.database.ReminderDao;
import com.mobiledev.nbascheduler.database.ReminderDataModel;
import com.mobiledev.nbascheduler.database.ReminderDatabase;

import java.util.ArrayList;
import java.util.List;

public class RemindersActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ListView listView;
    private List<Schedule> scheduleList;

    ReminderDatabase database;
    ReminderDataModel reminderData;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        database = ReminderDatabase.getDatabase(getApplicationContext());

        ReminderDao reminderDao = database.daoAccess();

        //Daily d1 = new Daily();
        listView = findViewById(R.id.reminderlist);
        scheduleList = new ArrayList<>();

        //Log.d("DB: ", reminderDB.daoAccess().getAllreminders().toString());

        List<ReminderDataModel> dbList = reminderDao.getAllreminders();

        for (int i = 0; i < dbList.size(); i++)
        {
            Log.d("DB", dbList.get(i).getHome_team());
        }

    }
}
