package com.mobiledev.nbascheduler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton dailybutton = findViewById(R.id.daily);
        AppCompatButton teamSchedbtn = findViewById(R.id.team_schedule);
        AppCompatButton newsbutton = findViewById(R.id.news);
        ImageView settingsbtn = findViewById(R.id.settings);

        dailybutton.setOnClickListener(this);
        teamSchedbtn.setOnClickListener(this);
        newsbutton.setOnClickListener(this);
        settingsbtn.setOnClickListener(this);

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
        }

    }
}
