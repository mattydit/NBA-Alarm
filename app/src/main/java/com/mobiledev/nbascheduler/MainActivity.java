package com.mobiledev.nbascheduler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
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

        dailybutton.setOnClickListener(this);
        teamSchedbtn.setOnClickListener(this);
        newsbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Context context = getApplicationContext();

        switch (v.getId())
        {
            case R.id.daily:
            {
                Intent daily_intent = new Intent(Intent.)
            }
        }

    }
}
