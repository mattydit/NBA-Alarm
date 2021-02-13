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
            switch (visitor)
            {
                case "Bucks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.bucks);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Bulls":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.bulls);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Cavaliers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.cavs);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Celtics":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.celtics);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Clippers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.clippers);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Grizzlies":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.grizzlies);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Hawks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.hawks);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Heat":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.heat);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Hornets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.hornets);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Jazz":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.jazz);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Kings":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.kings);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Knicks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.knicks);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Lakers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.lakers);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Magic":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.magic);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Mavericks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.mavs);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Nets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.nets);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Nuggets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.nuggets);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Pacers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pacers);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Pelicans":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pelicans);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Pistons":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pistons);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Raptors":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.raptors);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Rockets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.rockets);
                    item.setLogoAway(drawable);
                    break;
                }
                case "76ers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.sixers);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Spurs":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.spurs);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Suns":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.suns);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Thunder":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.thunder);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Timberwolves":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.wolves);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Trail Blazers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.blazers);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Warriors":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.warriors);
                    item.setLogoAway(drawable);
                    break;
                }
                case "Wizards":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.wizards);
                    item.setLogoAway(drawable);
                    break;
                }
            }

            switch (home)
            {
                case "Bucks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.bucks);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Bulls":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.bulls);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Cavaliers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.cavs);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Celtics":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.celtics);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Clippers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.clippers);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Grizzlies":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.grizzlies);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Hawks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.hawks);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Heat":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.heat);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Hornets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.hornets);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Jazz":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.jazz);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Kings":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.kings);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Knicks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.knicks);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Lakers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.lakers);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Magic":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.magic);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Mavericks":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.mavs);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Nets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.nets);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Nuggets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.nuggets);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Pacers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pacers);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Pelicans":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pelicans);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Pistons":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.pistons);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Raptors":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.raptors);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Rockets":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.rockets);
                    item.setLogoHome(drawable);
                    break;
                }
                case "76ers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.sixers);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Spurs":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.spurs);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Suns":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.suns);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Thunder":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.thunder);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Timberwolves":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.wolves);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Trail Blazers":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.blazers);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Warriors":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.warriors);
                    item.setLogoHome(drawable);
                    break;
                }
                case "Wizards":
                {
                    Drawable drawable = getResources().getDrawable(R.drawable.wizards);
                    item.setLogoHome(drawable);
                    break;
                }
            }

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
