package com.mobiledev.nbascheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UserSettings extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        //Spinner for picking favourite team.
        Spinner spinner = (Spinner) findViewById(R.id.teams_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        //Specify the layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        EditText usernameText = (EditText) findViewById(R.id.name_box);
        Button apply = (Button) findViewById(R.id.applybtn);

        apply.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                    }
                }
        );


    }

}
