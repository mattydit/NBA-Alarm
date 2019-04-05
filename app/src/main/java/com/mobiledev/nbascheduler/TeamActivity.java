package com.mobiledev.nbascheduler;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity
{
    private ProgressBar progressBar;
    private ListView listView;
    private List<Schedule> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        listView = findViewById(R.id.teamlist);
        progressBar = findViewById(R.id.progressbarteam);
        scheduleList = new ArrayList<>();



        //Fetch and parse data.
        loadList();
    }

    private void loadList()
    {
        String JSON_URL = "http://data.nba.com/data/10s/v2015/json/mobile_teams/nba/2018/league/00_full_schedule.json";

        //String request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Hide progress bar.
                        progressBar.setVisibility(View.GONE);
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

                                    SharedPreferences userPref = getApplicationContext().getSharedPreferences(
                                            "settingsPref", Context.MODE_PRIVATE);

                                    String fav_team = userPref.getString("fav_team", null);

                                    if (visitor.equals(fav_team) || home.equals(fav_team))
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
