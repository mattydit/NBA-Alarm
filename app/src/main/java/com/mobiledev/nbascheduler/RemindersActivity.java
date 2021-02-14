package com.mobiledev.nbascheduler;

import androidx.room.Room;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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

        final ReminderDao reminderDao = database.daoAccess();

        //Daily d1 = new Daily();
        listView = findViewById(R.id.reminderlist);
        scheduleList = new ArrayList<>();

        //Log.d("DB: ", reminderDB.daoAccess().getAllreminders().toString());

        List<ReminderDataModel> dbList = reminderDao.getAllreminders();

        for (int i = 0; i < dbList.size(); i++)
        {
            String visitor = dbList.get(i).getVisitor();
            String home = dbList.get(i).getHome_team();
            Log.d("DB", dbList.get(i).getHome_team());
            Schedule item = new Schedule();
            item.setGameID(dbList.get(i).getGameID());
            item.setG_date(dbList.get(i).getDate());
            item.setUTCtime(dbList.get(i).getTime());
            item.setVisitor_team(visitor);
            item.setHome_team(home);

            //logos
            TeamLogos teamLogos = new TeamLogos();
            item.setLogoAway(teamLogos.GetTeamLogo(visitor, getApplicationContext()));
            item.setLogoHome(teamLogos.GetTeamLogo(home,getApplicationContext()));

            //Add the game to list.
            scheduleList.add(item);
        }

        //Create custom adapter
        GamesAdapter adapter = new GamesAdapter(scheduleList, getApplicationContext());
        //Add adapter to ListView
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getBaseContext(), scheduleList.get(position).getGameID(), Toast.LENGTH_LONG).show();

                reminderDao.deleteGame(scheduleList.get(position).getGameID());

                scheduleList.remove(position);

                GamesAdapter adapter = new GamesAdapter(scheduleList, getApplicationContext());
                //Add adapter to ListView
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                return true;
            }
        });

    }

}
