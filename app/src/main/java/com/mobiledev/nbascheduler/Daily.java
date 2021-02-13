package com.mobiledev.nbascheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mobiledev.nbascheduler.database.ReminderDao;
import com.mobiledev.nbascheduler.database.ReminderDataModel;
import com.mobiledev.nbascheduler.database.ReminderDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Daily extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ListView listView;
    private List<Schedule> scheduleList;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date();
    String localDate = df.format(currentDate);

    SimpleDateFormat dt = new SimpleDateFormat("HH");
    Date currentTime = new Date();
    String localTime = dt.format(currentTime);



    ReminderDatabase database;
    ReminderDataModel reminderData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        Log.d("Current Date: ", localDate);
        Log.d("Current Time: ", localTime);

        //If current time is less than 04:00, show previous days games.
        if (Integer.parseInt(localTime) < 4)
        {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);

            localDate = df.format(cal.getTime());
        }

        database = ReminderDatabase.getDatabase(getApplicationContext());

        listView = findViewById(R.id.gamelist);
        progressBar = findViewById(R.id.progressbar);
        scheduleList = new ArrayList<>();

        //Fetch and parse data.
        loadList();

        //Insert chosen game into database by long clicking.
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {

                //String pos = Integer.toString(position);

                //scheduleList.get(position).getGameID();

                Toast.makeText(getBaseContext(), scheduleList.get(position).getGameID(), Toast.LENGTH_LONG).show();

                final String gameID = scheduleList.get(position).getGameID();
                final String g_date = scheduleList.get(position).getG_date();
                final String time = scheduleList.get(position).getUTCtime();
                final String visitor_team = scheduleList.get(position).getVisitor_team();
                final String home_team = scheduleList.get(position).getHome_team();

                Schedule reminder = new Schedule();
                reminder.setGameID(gameID);
                reminder.setG_date(g_date);
                reminder.setHome_team(home_team);
                reminder.setVisitor_team(visitor_team);
                reminder.setUTCtime(time);

                ReminderDao reminderDao = database.daoAccess();
                //Item to be inserted into database
                reminderData = new ReminderDataModel(gameID, g_date, time, visitor_team, home_team);

                reminderDao.insertGame(reminderData);

                return true;
            }
        });
    }

    private void loadList()
    {
        String JSON_URL = "http://data.nba.com/data/10s/v2015/json/mobile_teams/nba/2020/league/00_full_schedule.json";

        //String request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Hide progress bar.
                        progressBar.setVisibility(View.GONE);
                        //Show list
                        listView.setVisibility(View.VISIBLE);

                        //Show json in log
                        Log.d("JSON", response.toString());

                        try
                        {
                            JSONArray jsonArray = response.getJSONArray("lscd");

                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject jsonlscd = jsonArray.getJSONObject(i).getJSONObject("mscd");
                                JSONArray gArray = jsonlscd.getJSONArray("g");
                                for (int j = 0; j < gArray.length(); j++)
                                {
                                    JSONObject newOBJ = gArray.getJSONObject(j);
                                    String gid = newOBJ.getString("gid");
                                    //Log.d("Game ID: ", gid);
                                    String date = newOBJ.getString("gdte");
                                    //Log.d("Date: ", date);
                                    String time = newOBJ.getString("utctm");
                                    //Log.d("Time: ", time);
                                    JSONObject vOBJ = newOBJ.getJSONObject("v");
                                    String visitor = vOBJ.getString("tn");
                                    //Log.d("Visiting Team: ", visitor);
                                    JSONObject hOBJ = newOBJ.getJSONObject("h");
                                    String home = hOBJ.getString("tn");
                                    //Log.d("Home Team: ", home);

                                    //Compare game date to current time. If yes add to list.
                                    if (date.equals(localDate))
                                    {
                                        Log.d("Game ID: ", gid);
                                        Log.d("Date: ", date);
                                        Log.d("Time: ", time);
                                        Log.d("Visiting Team: ", visitor);
                                        Log.d("Home Team: ", home);

                                        Schedule item = new Schedule();
                                        item.setGameID(gid);
                                        item.setG_date(date);
                                        item.setUTCtime(time);
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
                                }
                            }
                            //Create custom adapter
                            GamesAdapter adapter = new GamesAdapter(scheduleList, getApplicationContext());
                            //Add adapter to ListView
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        progressBar.setVisibility(View.GONE);
                        //displaying the error in toast if occurred
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        ScheduleVolley.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
